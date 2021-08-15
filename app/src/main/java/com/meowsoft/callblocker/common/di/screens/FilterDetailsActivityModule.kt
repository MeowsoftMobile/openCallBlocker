package com.meowsoft.callblocker.common.di.screens

import com.meowsoft.callblocker.navigation.StartScreenUseCase
import com.meowsoft.callblocker.navigation.StartScreenUseCaseImpl
import com.meowsoft.callblocker.presentation.filterdetails.FilterDetailsViewModel
import com.meowsoft.callblocker.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val filterDetailsActivityModule = module {

    viewModel {
        FilterDetailsViewModel()
    }
}