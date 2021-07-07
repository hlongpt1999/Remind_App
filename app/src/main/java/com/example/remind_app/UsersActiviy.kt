package com.example.remind_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.remind_app.Objects.UsersDAO
import com.example.remind_app.Objects.UsersDatabase
import com.example.remind_app.Objects.UsersRepository
import com.example.remind_app.ViewModel.UsersViewModelFactory
import com.example.remind_app.databinding.ActivityUsersBinding

class UsersActiviy : AppCompatActivity() {

    private lateinit var bindling : ActivityUsersBinding
    private lateinit var usersViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        bindling = DataBindingUtil.setContentView(this, R.layout.activity_users)
        val dao:UsersDAO = UsersDatabase.getInstance(application).usersDAO
        val repository = UsersRepository(dao)
        val factory = UsersViewModelFactory(repository)
        usersViewModel = ViewModelProvider(this, factory).get(UsersViewModel::class.java)
        bindling.myViewModel = usersViewModel
        bindling.lifecycleOwner = this
        displayUsersList()

    }

    private fun displayUsersList(){
        usersViewModel.getUsers.observe(this, Observer {
            Log.i("MY TAG", it.toString())
        })
    }
}