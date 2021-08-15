package com.meowsoft.callblocker.common.navigation

sealed class Screen {
    object FilterDetailsScreen : Screen()
}

typealias FilterDetailsScreen = Screen.FilterDetailsScreen
