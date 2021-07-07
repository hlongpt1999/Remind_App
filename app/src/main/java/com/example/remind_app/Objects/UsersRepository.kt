package com.example.remind_app.Objects

class UsersRepository (private val dao : UsersDAO) {
    val getUsers = dao.getAllUser()

    suspend fun insert (users: Users){
        dao.insertUser(users)
    }

    suspend fun update (users: Users){
        dao.updateUser(users)
    }

    suspend fun delete (users: Users){
        dao.deleteUser(users)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}