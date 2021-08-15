package com.meowsoft.callblocker.domain

import com.meowsoft.callblocker.infrastructure.database.entity.FilterEntity

data class Filter(val name: String)

fun Filter.toFilterEntity() = FilterEntity(name)