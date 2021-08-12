package com.meowsoft.callblocker.presentation.main.pages.blocked

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.databinding.ViewBlockedCallsBinding

class BlockedCallsView(
    context: Context
) : ConstraintLayout(context) {

    init {
        DataBindingUtil.inflate<ViewBlockedCallsBinding>(
            LayoutInflater.from(context),
            R.layout.view_blocked_calls,
            this,
            true
        )

        layoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}