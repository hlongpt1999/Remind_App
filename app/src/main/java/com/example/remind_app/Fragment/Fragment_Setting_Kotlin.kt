package com.example.remind_app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.remind_app.R

class Fragment_Setting_Kotlin() : Fragment() {

//    private var _bindling : FragmentSettingBindling? = null
//    private val bindling get() = _bindling!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view :View = inflater.inflate(R.layout.fragment_setting, container, false)

//        _bindling = FragmentSettingBindling

                

        return view

    }
}