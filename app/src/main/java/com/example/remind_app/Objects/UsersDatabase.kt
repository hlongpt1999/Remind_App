package com.example.remind_app.Objects

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {

    abstract val usersDAO : UsersDAO

    companion object{
        @Volatile
        private var INSTANCE : UsersDatabase?=null
        fun getInstance (context: Context) : UsersDatabase{
            synchronized(this){
                var instance : UsersDatabase ?= INSTANCE
                if(instance == null){
                    instance =Room.databaseBuilder(
                            context.applicationContext,
                            UsersDatabase::class.java,
                            "user_database"
                    ).build()
                }
                return instance
            }
        }
    }
}