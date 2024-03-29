package com.meowsoft.callblocker.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.common.config.MenuConfig
import com.meowsoft.callblocker.domain.MenuPage

class MainViewModel : ViewModel() {

    val selectedPage = MutableLiveData(MenuConfig.getById(R.id.action_blocked_list))


    fun onPageChange(menuPage: MenuPage) {
        selectedPage.value = menuPage
    }
}