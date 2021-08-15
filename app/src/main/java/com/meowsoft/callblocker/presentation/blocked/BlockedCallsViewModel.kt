package com.meowsoft.callblocker.presentation.blocked

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meowsoft.callblocker.application.blocked.GetBlockedCalls
import com.meowsoft.callblocker.domain.CallLog
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

class BlockedCallsViewModel(
    private val getBlockedCalls: GetBlockedCalls
) : ViewModel() {

    val callLogs = MutableLiveData<List<CallLog>>(listOf())

    private val disposable = CompositeDisposable()

    init {
        getBlockedCalls()
    }

    private fun getBlockedCalls(){
        val sub = getBlockedCalls
            .execute()
            .subscribeBy(
                {

                },{

                },{
                    callLogs.value = it
                }
            )
        disposable.add(sub)
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

}