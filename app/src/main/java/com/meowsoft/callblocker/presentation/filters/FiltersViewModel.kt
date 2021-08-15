package com.meowsoft.callblocker.presentation.filters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meowsoft.callblocker.application.filters.GetFilters
import com.meowsoft.callblocker.domain.Filter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

class FiltersViewModel(
    private val getFilters: GetFilters
) : ViewModel() {

    val filtersData = MutableLiveData<List<Filter>>(listOf())

    private val disposable = CompositeDisposable()

    init {
        getFilters()
    }

    private fun getFilters(){

        val sub = getFilters
            .execute()
            .subscribeBy { filters ->
                filtersData.value = filters
            }

        disposable.add(sub)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}