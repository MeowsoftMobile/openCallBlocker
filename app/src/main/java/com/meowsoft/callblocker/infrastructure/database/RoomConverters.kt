package com.meowsoft.callblocker.infrastructure.database

import androidx.room.TypeConverter
import com.meowsoft.callblocker.common.config.FilterType

class RoomConverters {
    @TypeConverter
    fun filterTypeFromString(type: String): FilterType {
        return FilterType.valueOf(type)
    }

    @TypeConverter
    fun filterTypeToString(type: FilterType): String {
        return type.name
    }
}