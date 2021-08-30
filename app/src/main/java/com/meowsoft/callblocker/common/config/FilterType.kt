package com.meowsoft.callblocker.common.config

import com.meowsoft.callblocker.R

enum class FilterType {
    CONTAINS,
    STARTS_WITH,
    ENDS_WITH;

    fun toStringRes() =
        when (this) {
            ENDS_WITH -> R.string.ends_with_filter
            CONTAINS -> R.string.contains_filter
            STARTS_WITH -> R.string.starts_with_filter
        }
}