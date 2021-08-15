package com.meowsoft.callblocker.common.di

import androidx.room.Room
import com.meowsoft.callblocker.infrastructure.database.CallBlockerDatabase
import org.koin.dsl.module

val dataModule = module {
    single {
        Room.databaseBuilder(
            get(),
            CallBlockerDatabase::class.java,
            CallBlockerDatabase.NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<CallBlockerDatabase>().filtersDao() }
}