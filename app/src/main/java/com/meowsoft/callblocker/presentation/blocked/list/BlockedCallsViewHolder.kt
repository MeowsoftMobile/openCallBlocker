package com.meowsoft.callblocker.presentation.blocked.list

import androidx.recyclerview.widget.RecyclerView
import com.meowsoft.callblocker.databinding.ItemBlockedCallBinding
import com.meowsoft.callblocker.databinding.ItemFilterBinding
import com.meowsoft.callblocker.domain.CallLog
import com.meowsoft.callblocker.domain.Filter

class BlockedCallsViewHolder(
    private val binding: ItemBlockedCallBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(callLog: CallLog) {
        binding.callLog = callLog
    }

}