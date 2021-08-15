package com.meowsoft.callblocker.infrastructure.repository

import com.meowsoft.callblocker.domain.Filter
import io.reactivex.Completable
import io.reactivex.Flowable

interface FiltersRepository {
    fun getFilters(): Flowable<List<Filter>>
    fun insertFilter(filter: Filter): Completable
}