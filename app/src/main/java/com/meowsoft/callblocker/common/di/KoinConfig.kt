package com.meowsoft.callblocker.common.di

import com.meowsoft.callblocker.common.di.screens.blockedCallsFragmentModule
import com.meowsoft.callblocker.common.di.screens.filtersFragmentModule
import com.meowsoft.callblocker.common.di.screens.mainActivityModule

val allModules = listOf(
    appModule,
    mainActivityModule,
    filtersFragmentModule,
    blockedCallsFragmentModule
)