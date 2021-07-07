package com.example.remind_app.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.remind_app.Objects.UsersRepository
import com.example.remind_app.UsersViewModel

class UsersViewModelFactory(private val repository : UsersRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UsersRepository::class.java)){
            return UsersViewModel(repository) as T
        }
        throw IllegalArgumentException("!@ Unknow View Model Class ♥♥")
    }
}