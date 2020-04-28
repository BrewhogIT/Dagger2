package com.brewhog.android.dagger2.router

import androidx.appcompat.app.AppCompatActivity
import com.brewhog.android.dagger2.R
import com.brewhog.android.dagger2.ui.MainActivity
import com.brewhog.android.dagger2.ui.MyFragment
import javax.inject.Inject

class MainRouter<T : AppCompatActivity>@Inject constructor (val activity : T) {

    @Inject
    lateinit var myFragment: MyFragment

    fun addFragment(id : Int ){
        val fragmentManager = activity.supportFragmentManager
        val fragment = fragmentManager.findFragmentById(id)
        if (fragment == null){
            fragmentManager.beginTransaction()
                .add(id,myFragment)
                .commit()
        }
    }
}