package com.example.core.navigation

import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.SharedFlow

interface AppNavigationHandler {
    val backStack: SharedFlow<Navigator.() -> Unit>
}