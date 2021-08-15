package com.meowsoft.callblocker.common

import android.view.View
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.meowsoft.callblocker.common.config.MenuConfig
import com.meowsoft.callblocker.domain.CallLog
import com.meowsoft.callblocker.domain.Filter
import com.meowsoft.callblocker.domain.MenuPage
import com.meowsoft.callblocker.presentation.common.OnPageChangedListener
import com.meowsoft.callblocker.presentation.common.RvSupplier
import com.meowsoft.callblocker.presentation.blocked.list.BlockedCallsAdapter
import com.meowsoft.callblocker.presentation.filters.list.FiltersListAdapter
import com.meowsoft.callblocker.presentation.main.viewpager.FragmentAdapter

@BindingAdapter("selectedPositionAttrChanged")
fun Spinner.bindSelectionChangedListener(listener: InverseBindingListener?){
    if(listener != null){
        onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                listener.onChange()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}

@BindingAdapter("selectedPosition")
fun Spinner.bindSelected(position: Int){

    if(selectedItemPosition != position && position < adapter.count - 1){
        setSelection(position)
    }

}

@InverseBindingAdapter(attribute = "selectedPosition")
fun Spinner.getSelected() = selectedItemPosition

@BindingAdapter("adapter")
fun Spinner.bindAdapter(adapter: BaseAdapter) {
    this.adapter = adapter
}

@BindingAdapter("data")
fun RecyclerView.bindFiltersData(filters: List<Filter>) {
    adapter?.let {
        if (it is FiltersListAdapter) {
            it.data = filters
        }
    }
}

@BindingAdapter("data")
fun RecyclerView.bindCallLogsData(callLogs: List<CallLog>) {
    adapter?.let {
        if (it is BlockedCallsAdapter) {
            it.data = callLogs
        }
    }
}

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