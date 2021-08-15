package com.meowsoft.callblocker.common.config

import com.meowsoft.callblocker.R

enum class FilterType {
    IS,
    CONTAINS,
    STARTS_WITH;

    fun toStringRes() =
        when(this){
            IS -> R.string.is_filter
            CONTAINS -> R.string.contains_filter
            STARTS_WITH -> R.string.starts_with_filter
        }
}