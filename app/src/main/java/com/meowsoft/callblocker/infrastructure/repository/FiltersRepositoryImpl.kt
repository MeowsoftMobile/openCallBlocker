package com.meowsoft.callblocker.infrastructure.repository

import com.meowsoft.callblocker.domain.Filter
import io.reactivex.Flowable

class FiltersRepositoryImpl : FiltersRepository {

    override fun getFilters(): Flowable<List<Filter>> =
        Flowable.just(
            listOf(
                Filter("Filter A"),
                Filter("Filter B"),
                Filter("Filter C")
            )
        )

}