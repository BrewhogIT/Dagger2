package com.brewhog.android.dagger2.component

import android.app.Application
import com.brewhog.android.dagger2.App
import com.brewhog.android.dagger2.module.FragmentModule
import com.brewhog.android.dagger2.module.MainActivityModule
import com.brewhog.android.dagger2.module.SharedPrefModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    SharedPrefModule::class,
    MainActivityModule::class,
    FragmentModule::class])
interface MyComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): MyComponent
    }

    fun inject(app : App)
}