package com.meowsoft.callblocker.presentation.main.viewpager

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.presentation.main.pages.blocked.BlockedCallsView
import com.meowsoft.callblocker.presentation.main.pages.filters.FiltersView

class ViewPagerAdapter() : RecyclerView.Adapter<PageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, layout: Int): PageViewHolder {
        return PageViewHolder(getView(parent, layout))
    }

    private fun getView(parent: ViewGroup, layout: Int): View{
        return when(layout){
            R.layout.view_filters -> FiltersView(parent.context)
            R.layout.view_blocked_calls -> BlockedCallsView(parent.context)
            else -> BlockedCallsView(parent.context)
        }
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int =
        when(position){
            0 -> R.layout.view_blocked_calls
            1 -> R.layout.view_filters
            else -> R.layout.view_blocked_calls
        }

    override fun getItemCount(): Int = 2
}