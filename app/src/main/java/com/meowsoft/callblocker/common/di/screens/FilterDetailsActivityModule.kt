package com.meowsoft.callblocker.common.di.screens

import com.meowsoft.callblocker.presentation.filterdetails.FilterDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val filterDetailsActivityModule = module {

    viewModel {
        FilterDetailsViewModel()
    }
}