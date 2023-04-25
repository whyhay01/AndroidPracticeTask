package com.example.androidpracticaltest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidpracticaltest.models.AlbumPhoto
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumPhotoDao {

    @Query("SELECT * FROM AlbumPhoto")
    fun getAllAlbumPhotos():Flow<List<AlbumPhoto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbumPhoto(albumPhotos: List<AlbumPhoto>)

    @Query("DELETE from AlbumPhoto")
    suspend fun deleteAllAlbumPhoto()
}