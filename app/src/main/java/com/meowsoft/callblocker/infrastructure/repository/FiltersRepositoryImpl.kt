package com.meowsoft.callblocker.infrastructure.repository

import com.meowsoft.callblocker.domain.Filter
import com.meowsoft.callblocker.domain.toFilterEntity
import com.meowsoft.callblocker.infrastructure.database.dao.FiltersDao
import com.meowsoft.callblocker.infrastructure.database.entity.toFiltersList
import io.reactivex.Flowable

class FiltersRepositoryImpl(
    private val filtersDao: FiltersDao
) : FiltersRepository {

    override fun insertFilter(filter: Filter) =
        filtersDao
            .insert(
                filter.toFilterEntity()
            )

    override fun getFilters(): Flowable<List<Filter>> =
        filtersDao
            .subscribeAll()
            .map {
                it.toFiltersList()
            }

}