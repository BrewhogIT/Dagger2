package com.brewhog.android.dagger2

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),View.OnClickListener,HasSupportFragmentInjector {

    @Inject
    lateinit var sharedPreferences : SharedPreferences

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    override fun onClick(p0: View?) {
       when(p0?.id){
           R.id.btnGet -> {
               inUsername.setText(sharedPreferences.getString("username","default"))
               inNumber.setText(sharedPreferences.getString("number","12345"))
           }
           R.id.btnSave ->{
               val editor = sharedPreferences.edit()
               editor.putString("username",inUsername.text.toString().trim())
               editor.putString("number",inNumber.text.toString().trim())
               editor.apply()
           }
       }
    }

    fun initViews(){
        btnGet.setOnClickListener(this)
        btnSave.setOnClickListener(this)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}
