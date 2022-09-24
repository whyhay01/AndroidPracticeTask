package com.example.androidpracticaltest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidpracticaltest.models.Album
import com.example.androidpracticaltest.models.AlbumPhoto

@Database(entities = [Album::class, AlbumPhoto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao():AlbumDao
    abstract fun albumPhotoDao():AlbumPhotoDao
}