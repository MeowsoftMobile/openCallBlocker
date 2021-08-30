package com.meowsoft.callblocker.domain

import com.meowsoft.callblocker.common.config.FilterType
import com.meowsoft.callblocker.infrastructure.database.entity.FilterEntity

data class Filter(val name: String, val type: FilterType, val numberPattern: String)

fun Filter.toFilterEntity() = FilterEntity(name, type, numberPattern)