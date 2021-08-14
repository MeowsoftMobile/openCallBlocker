package com.meowsoft.callblocker.presentation.common

import com.meowsoft.callblocker.domain.MenuPage

interface OnPageChangedListener {
    fun onPageChanged(menuPage: MenuPage)
}