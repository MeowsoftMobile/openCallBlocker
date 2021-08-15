package com.meowsoft.callblocker.infrastructure.database.dao

import androidx.annotation.Keep
import androidx.room.*
import com.meowsoft.callblocker.infrastructure.database.entity.CallLogEntity
import com.meowsoft.callblocker.infrastructure.database.entity.FilterEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Keep
@Dao
abstract class CallLogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg callLog: CallLogEntity): Completable

    @Query("SELECT * FROM call_log")
    abstract fun subscribeAll(): Flowable<List<CallLogEntity>>

    @Query("DELETE FROM call_log")
    abstract fun deleteAll(): Completable
}