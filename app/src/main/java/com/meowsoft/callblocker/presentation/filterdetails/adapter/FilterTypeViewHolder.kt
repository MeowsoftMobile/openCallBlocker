package com.meowsoft.callblocker.presentation.filterdetails.adapter

import androidx.recyclerview.widget.RecyclerView
import com.meowsoft.callblocker.common.config.FilterType
import com.meowsoft.callblocker.databinding.ItemSpinnerFilterTypeBinding

class FilterTypeViewHolder(
    private val binding: ItemSpinnerFilterTypeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(filterType: String){
        binding.tvFilterType.text = filterType
    }
}