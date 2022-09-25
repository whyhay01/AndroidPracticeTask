package com.example.androidpracticaltest.repository

import com.example.androidpracticaltest.db.AppDatabase
import com.example.androidpracticaltest.models.AlbumPhoto
import com.example.androidpracticaltest.models.CustomResponse
import com.example.androidpracticaltest.network.NetworkService
import com.example.androidpracticaltest.utils.DataConverter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val service: NetworkService,
    private val db: AppDatabase,
    private val converter: DataConverter
) {

    private val flowable = Dispatchers.IO

    suspend fun getPhotos(): Flow<List<AlbumPhoto>>{
        val response = service.getPhotos()

        return flow {
            if (response.isSuccessful){
                emit((response.body())!!)
            }
        }.flowOn(flowable)
    }

}