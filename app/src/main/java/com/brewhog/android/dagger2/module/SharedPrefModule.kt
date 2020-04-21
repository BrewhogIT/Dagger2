package com.brewhog.android.dagger2.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPrefModule {

    @Singleton
    @Provides
    fun provideContext(application: Application):Context{
        return application
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context):SharedPreferences{
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}