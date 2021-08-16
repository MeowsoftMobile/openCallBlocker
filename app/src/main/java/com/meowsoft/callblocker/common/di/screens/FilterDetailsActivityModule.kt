package com.meowsoft.callblocker.common.di.screens

import com.meowsoft.callblocker.application.filterdetails.InsertFilter
import com.meowsoft.callblocker.application.filterdetails.InsertFiltersImpl
import com.meowsoft.callblocker.presentation.filterdetails.FilterDetailsActivity
import com.meowsoft.callblocker.presentation.filterdetails.FilterDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val filterDetailsActivityModule = module {

    single<InsertFilter>{
        InsertFiltersImpl(get())
    }

    viewModel { scope ->
        FilterDetailsViewModel(
            get()
        )
    }
}