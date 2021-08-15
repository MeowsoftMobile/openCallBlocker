package com.meowsoft.callblocker.infrastructure

import android.telecom.Call
import android.telecom.CallScreeningService

class CallBlockerService : CallScreeningService() {


    override fun onScreenCall(callDetails: Call.Details) {
        val x = 0
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