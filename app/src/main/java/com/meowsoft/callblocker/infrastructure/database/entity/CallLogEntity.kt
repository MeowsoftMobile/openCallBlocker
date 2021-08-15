package com.meowsoft.callblocker.infrastructure.database.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meowsoft.callblocker.domain.CallLog

@Keep
@Entity(tableName = "call_log")
data class CallLogEntity(
    val timeStamp: String,
    val number: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

fun CallLogEntity.toCallLog() = CallLog(number, timeStamp)

fun List<CallLogEntity>.toCallLogsList() = map {
    it.toCallLog()
}