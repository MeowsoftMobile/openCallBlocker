package com.meowsoft.callblocker.infrastructure.database

import androidx.annotation.Keep
import androidx.room.Database
import androidx.room.RoomDatabase
import com.meowsoft.callblocker.infrastructure.database.dao.CallLogDao
import com.meowsoft.callblocker.infrastructure.database.dao.FiltersDao
import com.meowsoft.callblocker.infrastructure.database.entity.CallLogEntity
import com.meowsoft.callblocker.infrastructure.database.entity.FilterEntity

@Keep
@Database(
    entities = [
        FilterEntity::class,
        CallLogEntity::class
    ],
    version = 2
)
abstract class CallBlockerDatabase : RoomDatabase() {
    abstract fun filtersDao(): FiltersDao
    abstract fun callLogDao(): CallLogDao

    companion object {
        const val NAME = "callblocker_db.db"
    }
}