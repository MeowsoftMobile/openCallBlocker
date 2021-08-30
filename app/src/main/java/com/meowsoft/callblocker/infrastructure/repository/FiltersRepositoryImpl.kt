package com.meowsoft.callblocker.infrastructure.repository

import com.meowsoft.callblocker.domain.Filter
import com.meowsoft.callblocker.domain.toFilterEntity
import com.meowsoft.callblocker.infrastructure.database.dao.FiltersDao
import com.meowsoft.callblocker.infrastructure.database.entity.toFiltersList
import io.reactivex.Flowable
import io.reactivex.Single

class FiltersRepositoryImpl(
    private val filtersDao: FiltersDao
) : FiltersRepository {

    override fun insertFilter(filter: Filter) =
        filtersDao
            .insert(
                filter.toFilterEntity()
            )

    override fun subscribeFilters(): Flowable<List<Filter>> =
        filtersDao
            .subscribeAll()
            .map {
                it.toFiltersList()
            }

    override fun getFilters(): Single<List<Filter>> =
        filtersDao
            .getAll()
            .map {
                it.toFiltersList()
            }

}