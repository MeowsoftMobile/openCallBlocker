package com.meowsoft.callblocker.common.navigation

import com.meowsoft.callblocker.common.navigation.screens.Screen

interface ScreenLauncher {
    fun startScreen(screen: Screen)
}
