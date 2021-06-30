package com.example.remind_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.remind_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var login : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//        var loginViewModel = LoginViewModel()
        login.loginViewModel
    }
}