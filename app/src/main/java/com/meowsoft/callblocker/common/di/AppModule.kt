package com.meowsoft.callblocker.common.di

import com.meowsoft.callblocker.infrastructure.repository.FiltersRepositoryImpl
import com.meowsoft.callblocker.infrastructure.repository.FiltersRepository
import org.koin.dsl.module

val appModule = module{

    single<FiltersRepository>{
        FiltersRepositoryImpl()
    }
}