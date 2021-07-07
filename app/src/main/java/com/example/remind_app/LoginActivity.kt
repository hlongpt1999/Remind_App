package com.example.remind_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.remind_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

//    val PACKAGE_CONTEXT:Context = applicationContext

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var login : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        var loginViewModel = LoginViewModel()
        login.loginViewModel= loginViewModel

//        btnLogin.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(p0: View?) {
//                moveToMain()
//            }
//        })
    }

    fun showToast(toast : String){
        Toast.makeText(this@LoginActivity, toast, Toast.LENGTH_SHORT).show()
    }

    fun moveToMain(){
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))

    }
}