package com.meowsoft.callblocker.common.di

import com.meowsoft.callblocker.common.navigation.ActivityProvider
import com.meowsoft.callblocker.common.navigation.ScreenLauncher
import com.meowsoft.callblocker.common.navigation.ScreenLauncherImpl
import com.meowsoft.callblocker.infrastructure.repository.FiltersRepositoryImpl
import com.meowsoft.callblocker.infrastructure.repository.FiltersRepository
import org.koin.dsl.module

val appModule = module{

    single(createdAtStart = true) { ActivityProvider(get()) }

    single<ScreenLauncher> {
        ScreenLauncherImpl(get())
    }

    single<FiltersRepository>{
        FiltersRepositoryImpl(get())
    }
}