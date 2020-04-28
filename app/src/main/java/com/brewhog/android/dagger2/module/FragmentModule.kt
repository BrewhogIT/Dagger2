package com.brewhog.android.dagger2.module

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.brewhog.android.dagger2.router.MainRouter
import com.brewhog.android.dagger2.ui.MainActivity
import com.brewhog.android.dagger2.ui.MyFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideFragment() : MyFragment{
        return MyFragment()
    }

//    @Provides
//    fun provideRouter(activity: MainActivity) : MainRouter{
//        return MainRouter(activity)
//    }

}