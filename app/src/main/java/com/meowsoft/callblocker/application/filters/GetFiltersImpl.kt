package com.meowsoft.callblocker.application.filters

import com.meowsoft.callblocker.domain.Filter
import com.meowsoft.callblocker.infrastructure.repository.FiltersRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetFiltersImpl(
    private val repository: FiltersRepository
) : GetFilters{

    override fun execute(): Flowable<List<Filter>> =
        repository.getFilters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}