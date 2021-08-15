package com.meowsoft.callblocker.presentation.main.viewpager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.meowsoft.callblocker.infrastructure.MenuConfig
import com.meowsoft.callblocker.presentation.blocked.BlockedCallsFragment
import com.meowsoft.callblocker.presentation.filters.FiltersFragment

class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = MenuConfig.count

    override fun createFragment(position: Int): Fragment =
        when(position){
            0 -> BlockedCallsFragment.getInstance()
            1 -> FiltersFragment.getInstance()
            else -> BlockedCallsFragment.getInstance()
        }
}