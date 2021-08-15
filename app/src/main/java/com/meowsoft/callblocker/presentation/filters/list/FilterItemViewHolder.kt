package com.meowsoft.callblocker.presentation.filters.list

import androidx.recyclerview.widget.RecyclerView
import com.meowsoft.callblocker.databinding.ItemFilterBinding
import com.meowsoft.callblocker.domain.Filter

class FilterItemViewHolder(
    private val binding: ItemFilterBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(filter: Filter){
        binding.filter = filter
    }

}