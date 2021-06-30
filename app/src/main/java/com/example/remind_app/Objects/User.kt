package com.example.remind_app.Objects

//MODEL in MVVM design pattern

class User () {
    lateinit var username:String
    lateinit var password:String

    constructor(username: String, password: String) : this() {
        this.username = username
        this.password = password
    }


}