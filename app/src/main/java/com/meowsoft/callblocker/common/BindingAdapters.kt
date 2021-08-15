package com.meowsoft.callblocker.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.meowsoft.callblocker.domain.MenuPage
import com.meowsoft.callblocker.infrastructure.MenuConfig
import com.meowsoft.callblocker.presentation.common.OnPageChangedListener
import com.meowsoft.callblocker.presentation.common.RvSupplier
import com.meowsoft.callblocker.presentation.main.viewpager.FragmentAdapter

@BindingAdapter("rvSupplier")
fun RecyclerView.bindAdapter(rvSupplier: RvSupplier) {
    adapter = rvSupplier.adapter
    layoutManager = rvSupplier.layoutManager
}

@BindingAdapter("adapter")
fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<*>) {
    setAdapter(adapter)
}

@BindingAdapter("selectedPage")
fun BottomNavigationView.setSelected(menuPage: MenuPage) {
    if (selectedItemId != menuPage.id) {
        selectedItemId = menuPage.id
    }
}

@BindingAdapter("onItemSelected")
fun BottomNavigationView.setOnSelectionChangeListener(listener: OnPageChangedListener) {
    setOnItemSelectedListener { menuItem ->

        listener.onPageChanged(MenuConfig.getById(menuItem.itemId))

        true
    }
}

@BindingAdapter("selectedPage")
fun ViewPager2.setSelectedPage(menuPage: MenuPage) {
    if (currentItem != menuPage.number) {
        setCurrentItem(menuPage.number, true)
    }
}

@BindingAdapter("onItemSelected")
fun ViewPager2.setOnSelectionChangeListener(listener: OnPageChangedListener) {

    registerOnPageChangeCallback(
        object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

                listener.onPageChanged(MenuConfig.getByPage(position))
            }
        }
    )
}

@BindingAdapter("adapter")
fun ViewPager2.bindAdapter(adapter: FragmentAdapter) {
    this.adapter = adapter
}