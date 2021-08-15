package com.meowsoft.callblocker.common.di.screens

import com.meowsoft.callblocker.presentation.blocked.BlockedCallsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val blockedCallsFragmentModule = module {

    viewModel {
        BlockedCallsViewModel()
    }
}