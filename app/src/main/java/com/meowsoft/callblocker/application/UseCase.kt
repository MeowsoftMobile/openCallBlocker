package com.meowsoft.callblocker.application

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Use case where result is returned via Flowable. Input parameter is required.
 */
interface FlowableUseCaseWithParam<PARAM, RESULT> {
    fun execute(param: PARAM): Flowable<RESULT>
}

/**
 * Use case where result is returned via Flowable. No input parameter is needed.
 */
interface FlowableUseCaseWithoutParam<RESULT> {
    fun execute(): Flowable<RESULT>
}

/**
 * Use case where result is returned via Single. Input parameter is required.
 */
interface SingleUseCaseWithParam<PARAM, RESULT> {
    fun execute(param: PARAM): Single<RESULT>
}

/**
 * Use case where result is returned via Single. No input parameter is needed.
 */
interface SingleUseCaseWithoutParam<RESULT> {
    fun execute(): Single<RESULT>
}

/**
 * Use case where optional result is returned via Maybe. Input parameter is required.
 */
interface MaybeUseCaseWithParam<PARAM, RESULT> {
    fun execute(param: PARAM): Maybe<RESULT>
}

/**
 * Use case where optional result is returned via Maybe. No input parameter is needed.
 */
interface MaybeUseCaseWithoutParam<RESULT> {
    fun execute(): Maybe<RESULT>
}

/**
 * Use case where performed operation success or failure is signaled via Completable. Input parameter is required.
 */
interface CompletableUseCaseWithParam<PARAM> {
    fun execute(param: PARAM): Completable
}

/**
 * Use case where performed operation success or failure is signaled via Completable. No input parameter is needed.
 */
interface CompletableUseCaseWithoutParam {
    fun execute(): Completable
}
