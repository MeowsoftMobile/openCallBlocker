package com.meowsoft.callblocker.infrastructure.database.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meowsoft.callblocker.common.config.FilterType
import com.meowsoft.callblocker.domain.Filter

@Keep
@Entity(tableName = "filters")
data class FilterEntity(
    val name: String,
    val type: FilterType,
    val numberPattern: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

fun FilterEntity.toFilter() = Filter(name, type, numberPattern)

fun List<FilterEntity>.toFiltersList() = map {
    it.toFilter()
}