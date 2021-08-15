package com.meowsoft.callblocker.common.navigation

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.meowsoft.callblocker.CallBlockerApplication

class ActivityProvider(applicationContext: Context) {

    var currentActivity: Activity? = null

    init {
        (applicationContext as CallBlockerApplication).registerActivityLifecycleCallbacks(
            object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                }

                override fun onActivityStarted(activity: Activity) {
                }

                override fun onActivityResumed(activity: Activity) {
                    currentActivity = activity
                }

                override fun onActivityPaused(activity: Activity) {
                    currentActivity = null
                }

                override fun onActivityStopped(activity: Activity) {
                }

                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                }

                override fun onActivityDestroyed(activity: Activity) {
                }
            }
        )
    }

}