package com.meowsoft.callblocker.common.navigation.screens

sealed class Screen {
    object FilterDetailsScreen: Screen()
}

typealias FilterDetailsScreen = Screen.FilterDetailsScreen
