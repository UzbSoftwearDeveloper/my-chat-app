package com.example.core.navigation

import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

object AppNavigatorDispatcher: AppNavigator, AppNavigationHandler {

    private val _backStack = MutableSharedFlow<Navigator.() -> Unit>( extraBufferCapacity = 1)
    override val backStack = _backStack.asSharedFlow()

    private val scope = CoroutineScope(Dispatchers.Main.immediate)


    override fun navigateTo(screen: MyScreen) =
        navigate {navigator -> navigator. push(screen) }

    override fun back() =
        navigate {navigator -> navigator. pop() }

    override fun replace(screen: MyScreen)=
        navigate {navigator ->
            navigator.replace(screen) }

    override fun replaceAll(screens: List<MyScreen>)=
        navigate{
            navigator -> navigator.replaceAll(screens)
        }

    private fun navigate(param : (Navigator)-> Unit){
        scope.launch {
            _backStack.emit(param)
        }
    }

}