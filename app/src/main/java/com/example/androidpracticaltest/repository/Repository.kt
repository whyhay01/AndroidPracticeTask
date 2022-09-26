package com.example.androidpracticaltest.repository

import androidx.room.withTransaction
import com.example.androidpracticaltest.db.AlbumPhotoDao
import com.example.androidpracticaltest.db.AppDatabase
import com.example.androidpracticaltest.network.NetworkService
import com.example.androidpracticaltest.utils.networkBoundResource
import javax.inject.Inject

class Repository @Inject constructor(
    private val service: NetworkService,
    private val db: AppDatabase,
    private val albumPhotoDao: AlbumPhotoDao
) {

    fun getAlbumPhoto() = networkBoundResource(
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

//    private val flowable = Dispatchers.IO
//
//    suspend fun getPhotos(): Flow<List<AlbumPhoto>>{
//        val response = service.getPhotos()
//
//        return flow {
//            if (response.isSuccessful){
//                emit((response.body())!!)
//            }
//        }.flowOn(flowable)
//    }

}