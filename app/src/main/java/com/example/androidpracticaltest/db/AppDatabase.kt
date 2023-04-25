package com.example.androidpracticaltest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidpracticaltest.models.AlbumPhoto

@Database(entities = [AlbumPhoto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumPhotoDao():AlbumPhotoDao
}