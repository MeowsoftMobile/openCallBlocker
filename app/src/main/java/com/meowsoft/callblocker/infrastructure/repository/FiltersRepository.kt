package com.meowsoft.callblocker.infrastructure.repository

import com.meowsoft.callblocker.domain.Filter
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface FiltersRepository {
    fun subscribeFilters(): Flowable<List<Filter>>
    fun getFilters(): Single<List<Filter>>
    fun insertFilter(filter: Filter): Completable
}