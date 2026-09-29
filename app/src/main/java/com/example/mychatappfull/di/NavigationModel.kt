package com.example.mychatappfull.di

import com.example.core.navigation.AppNavigationHandler
import com.example.core.navigation.AppNavigator
import com.example.core.navigation.AppNavigatorDispatcher
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
interface NavigationModel {

    @Binds
    fun bindAppNavigator(impl: AppNavigatorDispatcher): AppNavigator

    @Binds
    fun bindAppNavigationHandler(impl: AppNavigatorDispatcher): AppNavigationHandler

    companion object{

        @Provides
        fun provideAppNavigationDispatcher(): AppNavigatorDispatcher = AppNavigatorDispatcher
    }
}