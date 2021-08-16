package com.meowsoft.callblocker

import FileLoggingTree
import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.meowsoft.callblocker.common.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class CallBlockerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)

        Timber.plant(FileLoggingTree(this@CallBlockerApplication))

        startKoin {
            androidLogger()
            androidContext(this@CallBlockerApplication)
            modules(allModules)
        }

        Timber.d("Test log")
    }
}