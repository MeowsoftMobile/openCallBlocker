package com.meowsoft.callblocker.application.filterdetails

import com.meowsoft.callblocker.domain.Filter
import com.meowsoft.callblocker.infrastructure.repository.FiltersRepository
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InsertFiltersImpl(
    private val repository: FiltersRepository
) : InsertFilter {

    override fun execute(param: Filter): Completable =
        repository
            .insertFilter(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}