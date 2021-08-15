package com.meowsoft.callblocker.presentation.filterdetails

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meowsoft.callblocker.application.filterdetails.InsertFilter
import com.meowsoft.callblocker.common.config.FilterType
import com.meowsoft.callblocker.domain.Filter
import com.meowsoft.callblocker.presentation.filterdetails.event.FilterCreatedEvent
import com.meowsoft.callblocker.presentation.filterdetails.event.OutputEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

class FilterDetailsViewModel(
    private val insertFilter: InsertFilter
) : ViewModel() {

    val number = MutableLiveData("")
    val selectedFilterPos = MutableLiveData(0)

    val outputEvent: LiveData<OutputEvent>
        get() = _outputEvent
    private val _outputEvent = MutableLiveData<OutputEvent>()

    private val disposable = CompositeDisposable()

    fun onConfirmClick(view: View){
        val sub = insertFilter
            .execute(
                Filter(
                    "${resolveFilter()} ${number.value}"
                )
            )
            .subscribeBy {
                _outputEvent.value = FilterCreatedEvent
            }

        disposable.add(sub)
    }

    private fun resolveFilter(): FilterType{

        val listOfTypes = FilterType.values()
        val selectedType = listOfTypes[selectedFilterPos.value ?: 0]

        return selectedType
    }

    override fun onCleared() {
        disposable.clear()

        super.onCleared()
    }
}