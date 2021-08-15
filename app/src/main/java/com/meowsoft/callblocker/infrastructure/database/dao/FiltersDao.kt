package com.meowsoft.callblocker.infrastructure.database.dao

import androidx.annotation.Keep
import androidx.room.*
import com.meowsoft.callblocker.infrastructure.database.entity.FilterEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Keep
@Dao
abstract class FiltersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg filter: FilterEntity): Completable

    @Update
    abstract fun update(vararg filter: FilterEntity)

    @Query("SELECT * FROM filters")
    abstract fun subscribeAll(): Flowable<List<FilterEntity>>

    @Query("SELECT * FROM filters")
    abstract fun getAll(): Single<List<FilterEntity>>

    @Query("DELETE FROM filters")
    abstract fun deleteAll(): Completable

}