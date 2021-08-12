package com.meowsoft.callblocker.presentation.main.pages.filters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.databinding.ViewBlockedCallsBinding
import com.meowsoft.callblocker.databinding.ViewFiltersBinding

class FiltersView(
    context: Context
) : ConstraintLayout(context) {

    init {
        DataBindingUtil.inflate<ViewFiltersBinding>(
            LayoutInflater.from(context),
            R.layout.view_filters,
            this,
            true
        )

        layoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}