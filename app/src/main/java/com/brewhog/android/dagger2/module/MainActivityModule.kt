package com.brewhog.android.dagger2.module

import com.brewhog.android.dagger2.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @ContributesAndroidInjector
    fun contributesMainActivity() : MainActivity

}