package com.meowsoft.callblocker.presentation.blocked.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meowsoft.callblocker.databinding.ItemBlockedCallBinding
import com.meowsoft.callblocker.databinding.ItemFilterBinding
import com.meowsoft.callblocker.domain.CallLog
import com.meowsoft.callblocker.domain.Filter

class BlockedCallsAdapter : RecyclerView.Adapter<BlockedCallsViewHolder>() {

    var data: List<CallLog> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockedCallsViewHolder =
        BlockedCallsViewHolder(
            ItemBlockedCallBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BlockedCallsViewHolder, position: Int) {
        holder.bind(
            data[position]
        )
    }

    override fun getItemCount() = data.count()

}