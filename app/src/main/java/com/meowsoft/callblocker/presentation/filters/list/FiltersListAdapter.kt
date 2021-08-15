package com.meowsoft.callblocker.presentation.filters.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meowsoft.callblocker.databinding.ItemFilterBinding
import com.meowsoft.callblocker.domain.Filter

class FiltersListAdapter : RecyclerView.Adapter<FilterItemViewHolder>() {

    var data: List<Filter> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterItemViewHolder =
        FilterItemViewHolder(
            ItemFilterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FilterItemViewHolder, position: Int) {
        holder.bind(
            data[position]
        )
    }

    override fun getItemCount() = data.count()

}