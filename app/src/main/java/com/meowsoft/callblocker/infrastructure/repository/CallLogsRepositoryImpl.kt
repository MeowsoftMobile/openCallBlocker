package com.meowsoft.callblocker.infrastructure.repository

import com.meowsoft.callblocker.domain.CallLog
import com.meowsoft.callblocker.domain.Filter
import com.meowsoft.callblocker.domain.toCallLogEntity
import com.meowsoft.callblocker.domain.toFilterEntity
import com.meowsoft.callblocker.infrastructure.database.dao.CallLogDao
import com.meowsoft.callblocker.infrastructure.database.dao.FiltersDao
import com.meowsoft.callblocker.infrastructure.database.entity.toCallLogsList
import com.meowsoft.callblocker.infrastructure.database.entity.toFiltersList
import io.reactivex.Completable
import io.reactivex.Flowable

class CallLogsRepositoryImpl(
    private val callLogDao: CallLogDao
) : CallLogsRepository {

    override fun getCallLogs(): Flowable<List<CallLog>> =
        callLogDao
            .subscribeAll()
            .map {
                it.toCallLogsList()
            }


    override fun insertCallLog(callLog: CallLog): Completable =
        callLogDao
            .insert(
                callLog.toCallLogEntity()
            )
}