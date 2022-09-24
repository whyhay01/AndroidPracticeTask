package com.example.androidpracticaltest.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Album")
data class Album(
    val userId:Int,
    @PrimaryKey val id:Int,
    val title:String
    )
