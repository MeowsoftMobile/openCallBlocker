package com.meowsoft.callblocker.infrastructure

import com.meowsoft.callblocker.common.config.FilterType
import com.meowsoft.callblocker.domain.Filter

class CallJudge {

    companion object {
        fun validateCall(number: String, filters: List<Filter>): Verdict {
            filters.forEach {
                when (it.type) {
                    FilterType.STARTS_WITH -> {
                        if (number.startsWith(it.numberPattern)) {
                            return Verdict.BLOCK
                        }
                    }
                    FilterType.CONTAINS -> {
                        if (number.contains(it.numberPattern)) {
                            return Verdict.BLOCK
                        }
                    }
                    FilterType.ENDS_WITH -> {
                        if (number.endsWith(it.numberPattern)) {
                            return Verdict.BLOCK
                        }
                    }
                }

            }
            return Verdict.PASS
        }
    }

    enum class Verdict {
        PASS,
        BLOCK;
    }
}