package com.brewhog.android.dagger2.module

import androidx.appcompat.app.AppCompatActivity
import com.brewhog.android.dagger2.router.MainRouter
import com.brewhog.android.dagger2.scopes.ActivityScope
import com.brewhog.android.dagger2.scopes.FragmentScope
import com.brewhog.android.dagger2.ui.MainActivity
import com.brewhog.android.dagger2.ui.MyFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun contributesMainActivity() : MainActivity

    @FragmentScope
    @ContributesAndroidInjector
    fun contributesFragment() : MyFragment

}