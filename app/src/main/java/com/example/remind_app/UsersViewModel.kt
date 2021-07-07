package com.example.remind_app

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remind_app.Objects.Users
import com.example.remind_app.Objects.UsersRepository
import kotlinx.coroutines.launch

class UsersViewModel(private val repository : UsersRepository) : ViewModel(), Observable {
    val getUsers = repository.getUsers

    @Bindable
    val inputName =  MutableLiveData<String?>()

    @Bindable
    val inputEmail = MutableLiveData<String?>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllorDeleteButtonText = MutableLiveData<String>()

    init{
        saveOrUpdateButtonText.value = "Save"
        clearAllorDeleteButtonText.value = "Clear All"
    }

    fun onSave_Update(){
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Users(0, name, email))
        inputName.value=null
        inputEmail.value=null
    }

    fun onClearAll_Delete(){

    }

    fun insert (user: Users) =  viewModelScope.launch {
            repository.insert(user)
    }

    fun update(user: Users) = viewModelScope.launch {
        repository.update(user)
    }

    fun delete(user: Users) = viewModelScope.launch {
        repository.delete(user)
    }
    fun clearAll(user: Users) = viewModelScope.launch {
        repository.deleteAll()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}