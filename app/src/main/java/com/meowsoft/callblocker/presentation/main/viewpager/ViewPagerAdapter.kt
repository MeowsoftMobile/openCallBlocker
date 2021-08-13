package com.meowsoft.callblocker.presentation.main.viewpager

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.infrastructure.MenuConfig
import com.meowsoft.callblocker.presentation.main.pages.blocked.BlockedCallsView
import com.meowsoft.callblocker.presentation.main.pages.filters.FiltersView

class ViewPagerAdapter() : RecyclerView.Adapter<PageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, layout: Int): PageViewHolder {
        return PageViewHolder(getView(parent, layout))
    }

    private fun getView(parent: ViewGroup, layout: Int): View{
        val context = parent.context

        return when(layout){
            R.layout.view_filters -> FiltersView(context)
            R.layout.view_blocked_calls -> BlockedCallsView(context)
            else -> BlockedCallsView(context)
        }
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int = MenuConfig.getByPage(position).layout


    override fun getItemCount(): Int = MenuConfig.count
}