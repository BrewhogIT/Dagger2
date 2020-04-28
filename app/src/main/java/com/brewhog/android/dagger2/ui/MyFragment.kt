package com.brewhog.android.dagger2.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.brewhog.android.dagger2.R
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment.*
import javax.inject.Inject

class MyFragment constructor() : Fragment(),View.OnClickListener {
    @Inject
    lateinit var sharedPreferences : SharedPreferences

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment,container,false)
        initViews(view)
        return view
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

    fun initViews(view : View){
        val getButton = view.findViewById<Button>(R.id.btnGet)
        val saveButton = view.findViewById<Button>(R.id.btnSave)
        getButton.setOnClickListener(this)
        saveButton.setOnClickListener(this)
    }
}