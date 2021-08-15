package com.meowsoft.callblocker.common.di.screens

import com.meowsoft.callblocker.application.blocked.GetBlockedCalls
import com.meowsoft.callblocker.application.blocked.GetBlockedCallsImpl
import com.meowsoft.callblocker.application.filterdetails.InsertFilter
import com.meowsoft.callblocker.application.filterdetails.InsertFiltersImpl
import com.meowsoft.callblocker.presentation.blocked.BlockedCallsFragment
import com.meowsoft.callblocker.presentation.blocked.BlockedCallsViewModel
import com.meowsoft.callblocker.presentation.filterdetails.FilterDetailsActivity
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val blockedCallsFragmentModule = module {

    single<GetBlockedCalls>{
        GetBlockedCallsImpl(get())
    }

    viewModel { scope ->
        BlockedCallsViewModel(
            get()
        )
    }
}