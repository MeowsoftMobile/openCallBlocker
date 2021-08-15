package com.meowsoft.callblocker.presentation.filters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meowsoft.callblocker.databinding.ItemFilterBinding

class FiltersListAdapter : RecyclerView.Adapter<FilterItemViewHolder>() {

    val data = listOf(1,2,3)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterItemViewHolder =
        FilterItemViewHolder(
            ItemFilterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: FilterItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = data.count()

}