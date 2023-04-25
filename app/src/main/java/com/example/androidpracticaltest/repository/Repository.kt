package com.example.androidpracticaltest.repository

import android.util.Log
import androidx.room.withTransaction
import com.example.androidpracticaltest.db.AlbumPhotoDao
import com.example.androidpracticaltest.db.AppDatabase
import com.example.androidpracticaltest.models.AlbumPhoto
import com.example.androidpracticaltest.network.NetworkService
import com.example.androidpracticaltest.utils.Resource
import com.example.androidpracticaltest.utils.networkBoundResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(
    private val service: NetworkService,
    private val db: AppDatabase,
    private val albumPhotoDao: AlbumPhotoDao
) {

    fun getAlbumPhoto(): Flow<Resource<List<AlbumPhoto>>> = networkBoundResource(
        query = {
            albumPhotoDao.getAllAlbumPhotos()
        },
        fetch = {
                service.getPhotos()

        }, saveFetchResult = {albumPhotos ->
            db.withTransaction {
                albumPhotoDao.deleteAllAlbumPhoto()
                albumPhotoDao.insertAlbumPhoto(albumPhotos)
            }
        }

    )


}