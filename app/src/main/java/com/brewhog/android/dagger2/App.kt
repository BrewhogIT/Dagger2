package com.brewhog.android.dagger2

import android.app.Activity
import android.app.Application
import android.content.Context
import com.brewhog.android.dagger2.component.DaggerMyComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    fun initDagger(){
        DaggerMyComponent.builder().application(this).build().inject(this)
    }
}