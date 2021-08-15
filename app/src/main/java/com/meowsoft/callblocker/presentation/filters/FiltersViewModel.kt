package com.meowsoft.callblocker.presentation.filters

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meowsoft.callblocker.application.filters.GetFilters
import com.meowsoft.callblocker.application.filters.InsertFilter
import com.meowsoft.callblocker.domain.Filter
import com.meowsoft.callblocker.application.navigation.StartScreenUseCase
import com.meowsoft.callblocker.common.navigation.Screen
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

class FiltersViewModel(
    private val getFilters: GetFilters,
    private val insertFilter: InsertFilter,
    private val startScreen: StartScreenUseCase
) : ViewModel() {

    val filtersData = MutableLiveData<List<Filter>>(listOf())

    private val disposable = CompositeDisposable()

    init {
        getFilters()
    }

    fun onFabClick(view: View) {
        startScreen
            .execute(
                Screen.FilterDetailsScreen
            )
            .subscribe()
    }

    private fun insertFilter(filter: Filter) {
        val sub = insertFilter
            .execute(filter)
            .subscribeBy {

            }

        disposable.add(sub)
    }

    private fun getFilters() {

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