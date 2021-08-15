package com.meowsoft.callblocker.presentation.common

import androidx.recyclerview.widget.RecyclerView

data class RvSupplier(
    val adapter: RecyclerView.Adapter<*>,
    val layoutManager: RecyclerView.LayoutManager
)