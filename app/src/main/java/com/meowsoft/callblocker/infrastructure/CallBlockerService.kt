package com.meowsoft.callblocker.infrastructure

import android.telecom.Call
import android.telecom.CallScreeningService
import com.meowsoft.callblocker.domain.CallLog
import com.meowsoft.callblocker.infrastructure.repository.CallLogsRepository
import com.meowsoft.callblocker.infrastructure.repository.FiltersRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject
import org.threeten.bp.OffsetDateTime.now
import org.threeten.bp.format.DateTimeFormatter
import timber.log.Timber

class CallBlockerService : CallScreeningService() {

    private val callLogRepository: CallLogsRepository by inject()
    private val filtersRepository: FiltersRepository by inject()

    private val disposable = CompositeDisposable()

    companion object {
        private const val LOG_TAG = "CallBlockerService"
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }

    override fun onScreenCall(callDetails: Call.Details) {

        val number = callDetails.handle.schemeSpecificPart
        val timeStamp = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(now())

        Timber.tag(LOG_TAG).d("Incoming call: $number")

        val sub = filtersRepository
            .getFilters()
            .map {
                CallJudge.validateCall(number, it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { verdict ->
                if (verdict == CallJudge.Verdict.BLOCK) {
                    val sub = callLogRepository.insertCallLog(
                        CallLog(
                            number,
                            timeStamp
                        )
                    )
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()

                    disposable.add(sub)

                    respondToCall(
                        callDetails,
                        with(CallResponse.Builder()) {
                            setDisallowCall(true)
                            setRejectCall(false)
                            setSilenceCall(true)
                            setSkipCallLog(true)
                            setSkipNotification(true)
                            build()
                        }
                    )
                }
            }
    }
}