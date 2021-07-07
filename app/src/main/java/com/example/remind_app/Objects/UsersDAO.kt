package com.example.remind_app.Objects

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UsersDAO {
    @Insert
    suspend fun insertUser (users: Users) : Long

    @Update
    suspend fun updateUser (users: Users)

    @Delete
    suspend fun deleteUser (users: Users)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()

    @Query("SELECT * from user_table")
    fun getAllUser() : LiveData<List<Users>>





//
//    @Insert
//    fun insertUser2 (users: Users) : Long
//
//    @Insert
//    fun insertUsers (users: Users, users2: Users, users3: Users) : List<Long>
//
//    @Insert
//    fun insertUsers (users: List<Users>) : List<Long>
//
//
//    @Insert
//    fun insertUsers (user: Users, users: List<Users>) : List<Long>

}