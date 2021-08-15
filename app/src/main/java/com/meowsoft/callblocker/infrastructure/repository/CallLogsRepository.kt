package com.meowsoft.callblocker.infrastructure.repository

import com.meowsoft.callblocker.domain.CallLog
import io.reactivex.Completable
import io.reactivex.Flowable

interface CallLogsRepository {
    fun getCallLogs(): Flowable<List<CallLog>>
    fun insertCallLog(callLog: CallLog): Completable
}