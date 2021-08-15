package com.meowsoft.callblocker.application.blocked

import com.meowsoft.callblocker.application.FlowableUseCaseWithoutParam
import com.meowsoft.callblocker.domain.CallLog
import com.meowsoft.callblocker.infrastructure.repository.CallLogsRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetBlockedCallsImpl(
    private val callLogsRepository: CallLogsRepository
) : GetBlockedCalls {
    override fun execute(): Flowable<List<CallLog>> =
        callLogsRepository
            .getCallLogs()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
