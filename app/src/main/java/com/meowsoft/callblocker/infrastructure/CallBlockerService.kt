package com.meowsoft.callblocker.infrastructure

import android.telecom.Call
import android.telecom.CallScreeningService
import android.util.Log
import com.google.type.DateTime
import com.meowsoft.callblocker.domain.CallLog
import com.meowsoft.callblocker.infrastructure.repository.CallLogsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject
import org.threeten.bp.OffsetDateTime.now
import org.threeten.bp.format.DateTimeFormatter

class CallBlockerService : CallScreeningService() {

    private val callLogRepository: CallLogsRepository by inject()
    private val disposable = CompositeDisposable()

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }

    override fun onScreenCall(callDetails: Call.Details) {

        val number = callDetails.handle.schemeSpecificPart
        val timeStamp = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(now())

        Log.d("TEST", "Incoming call: $timeStamp - $number")

        val sub = callLogRepository.insertCallLog(
            CallLog(
                number,
                timeStamp
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy({
                  Log.d("TEST", "Error: ${it.message} - ${it.cause}")
            },{
                Log.d("TEST", "Registered new incoming call: $timeStamp - $number")
            })

        disposable.add(sub)

        respondToCall(
            callDetails,
            with(CallResponse.Builder()) {
                setDisallowCall(false)
                setRejectCall(false)
                setSilenceCall(false)
                setSkipCallLog(false)
                setSkipNotification(false)
                build()
            }
        )
    }
}