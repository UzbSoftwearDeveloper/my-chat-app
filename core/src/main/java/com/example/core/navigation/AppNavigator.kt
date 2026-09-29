package com.example.core.navigation


interface AppNavigator {
    fun navigateTo(screen: MyScreen)
    fun back()
    fun replace(screen: MyScreen)
    fun replaceAll(screens: List<MyScreen>)
}