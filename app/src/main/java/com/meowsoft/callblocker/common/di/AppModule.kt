package com.meowsoft.callblocker.common.di

import com.meowsoft.callblocker.common.navigation.ActivityProvider
import com.meowsoft.callblocker.common.navigation.ScreenLauncher
import com.meowsoft.callblocker.common.navigation.ScreenLauncherImpl
import com.meowsoft.callblocker.infrastructure.repository.CallLogsRepository
import com.meowsoft.callblocker.infrastructure.repository.CallLogsRepositoryImpl
import com.meowsoft.callblocker.infrastructure.repository.FiltersRepository
import com.meowsoft.callblocker.infrastructure.repository.FiltersRepositoryImpl
import org.koin.dsl.module

val appModule = module {

    single(createdAtStart = true) { ActivityProvider(get()) }

    single<ScreenLauncher> {
        ScreenLauncherImpl(get())
    }

    single<FiltersRepository> {
        FiltersRepositoryImpl(get())
    }

    single<CallLogsRepository> {
        CallLogsRepositoryImpl(get())
    }
}