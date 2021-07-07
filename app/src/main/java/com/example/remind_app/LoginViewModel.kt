package com.example.remind_app

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import com.example.remind_app.Objects.User

//VIEWMODEL in MVVM design pattern
public class LoginViewModel : BaseObservable(){

    var messageLogin: ObservableField<String> = ObservableField<String>()
    var isShowMessage: ObservableField<Boolean> = ObservableField<Boolean>(false)

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



    fun onClickLogin(view :View ){
        var user = User(username, password)

        if (user.username.equals("admin") && user.password.equals("admin")) {
            var context: Context = view.context
            var intent = Intent(context, MainActivity::class.java)
            isShowMessage.set(false)
            context.startActivity(intent)
        }
        else {
            messageLogin.set ("wrong")
            isShowMessage.set(true)
        }
    }

    fun hideMessage(){
        isShowMessage.set(false)
    }

    fun onClickNewActivity(view : View){
        var context: Context = view.context
        var intent = Intent(context, UsersActiviy::class.java)
        isShowMessage.set(false)
        context.startActivity(intent)
    }
}