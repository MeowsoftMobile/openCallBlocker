package com.meowsoft.callblocker.navigation

import com.meowsoft.callblocker.common.navigation.ScreenLauncher
import com.meowsoft.callblocker.common.navigation.screens.Screen
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber

class StartScreenUseCaseImpl(
    private val screenLauncher: ScreenLauncher
) : StartScreenUseCase {
    override fun execute(param: Screen): Completable =
        Completable.fromCallable {
            Timber.d("Launching screen: %s", param.toString())
            screenLauncher.startScreen(param)
        }
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
}
