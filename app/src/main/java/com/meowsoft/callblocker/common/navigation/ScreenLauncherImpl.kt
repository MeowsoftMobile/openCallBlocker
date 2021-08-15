package com.meowsoft.callblocker.common.navigation

import com.meowsoft.callblocker.presentation.filterdetails.FilterDetailsActivity

class ScreenLauncherImpl(
    private val activityProvider: ActivityProvider
) : ScreenLauncher {

    override fun startScreen(screen: Screen) {
        val activity = activityProvider.currentActivity!!

        when (screen) {
            is FilterDetailsScreen -> FilterDetailsActivity.start(activity)
        }
    }

}