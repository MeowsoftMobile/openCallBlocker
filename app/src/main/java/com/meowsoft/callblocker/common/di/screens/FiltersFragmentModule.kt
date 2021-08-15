package com.meowsoft.callblocker.common.di.screens

import com.meowsoft.callblocker.application.filters.GetFilters
import com.meowsoft.callblocker.application.filters.GetFiltersImpl
import com.meowsoft.callblocker.presentation.filters.FiltersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val filtersFragmentModule = module {

    single<GetFilters>{
        GetFiltersImpl(get())
    }

    viewModel {
        FiltersViewModel(
            get()
        )
    }
}