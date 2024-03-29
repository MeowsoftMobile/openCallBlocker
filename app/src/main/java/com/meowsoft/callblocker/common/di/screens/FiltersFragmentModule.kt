package com.meowsoft.callblocker.common.di.screens

import com.meowsoft.callblocker.application.filters.GetFilters
import com.meowsoft.callblocker.application.filters.GetFiltersImpl
import com.meowsoft.callblocker.application.filterdetails.InsertFilter
import com.meowsoft.callblocker.application.filterdetails.InsertFiltersImpl
import com.meowsoft.callblocker.application.navigation.StartScreenUseCase
import com.meowsoft.callblocker.application.navigation.StartScreenUseCaseImpl
import com.meowsoft.callblocker.presentation.filters.FiltersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val filtersFragmentModule = module {

    single<StartScreenUseCase> {
        StartScreenUseCaseImpl(get())
    }

    single<GetFilters> {
        GetFiltersImpl(get())
    }

    single<InsertFilter> {
        InsertFiltersImpl(get())
    }

    viewModel {
        FiltersViewModel(
            get(),
            get(),
            get()
        )
    }
}