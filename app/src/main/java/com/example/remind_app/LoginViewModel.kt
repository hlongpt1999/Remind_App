package com.example.remind_app

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

//VIEWMODEL in MVVM design pattern

public class LoginViewModel : BaseObservable(){
    var messageLogin = ObservableField<String>()

    @get: Bindable
    var username : String = ""
        set(value) {
        field = value
        notifyPropertyChanged(BR.username)
    }

    @get:Bindable
    var password :String = ""
        set(value) {
        field = value
        notifyPropertyChanged(BR.password)
    }

    fun onClickLogin(){
//        var user = User(username, password)
//        if (user.username.equals("Admin") && user.password.equals("Admin")){
//            messageLogin.set("Login success")
//        }
//        else
            messageLogin.set("")
    }

}