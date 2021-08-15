package com.meowsoft.callblocker.domain

import com.meowsoft.callblocker.infrastructure.database.entity.CallLogEntity

data class CallLog(val number: String, val timeStamp: String)

fun CallLog.toCallLogEntity() = CallLogEntity(timeStamp, number)