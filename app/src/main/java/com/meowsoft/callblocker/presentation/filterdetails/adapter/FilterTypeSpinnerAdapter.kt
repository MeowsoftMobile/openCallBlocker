package com.meowsoft.callblocker.presentation.filterdetails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.meowsoft.callblocker.common.config.FilterType
import com.meowsoft.callblocker.databinding.ItemSpinnerFilterTypeBinding

class FilterTypeSpinnerAdapter(context: Context) : BaseAdapter() {

    private val inflater = LayoutInflater.from(context)
    private val data = FilterType
        .values()
        .map {
            context.resources.getString(it.toStringRes())
        }

    override fun getCount() = data.size

    override fun getItem(position: Int) = data[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View =
        if (convertView == null) {
            val binding = ItemSpinnerFilterTypeBinding.inflate(inflater)

            with(FilterTypeViewHolder(binding)) {
                bind(data[position])
                itemView.tag = this
                itemView
            }

        } else {
            with(convertView.tag as FilterTypeViewHolder) {
                bind(data[position])
                itemView
            }
        }
}