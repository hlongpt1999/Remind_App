package com.example.remind_app.Objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class Users(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name="user_id")
        val id : Int,

        @ColumnInfo(name="user_name")
        val name : String,

        @ColumnInfo(name="user_email")
        val email : String,
)
