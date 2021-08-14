package com.meowsoft.callblocker.presentation.main

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.meowsoft.callblocker.R
import com.meowsoft.callblocker.domain.MenuPage
import com.meowsoft.callblocker.infrastructure.MenuConfig

class MainViewModel : ViewModel() {

    val selectedPage = MutableLiveData(MenuConfig.getById(R.id.action_blocked_list))


    fun onPageChange(menuPage: MenuPage){
        selectedPage.value = menuPage
    }
}