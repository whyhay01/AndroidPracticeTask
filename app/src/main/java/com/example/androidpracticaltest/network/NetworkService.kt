package com.example.androidpracticaltest.network

import com.example.androidpracticaltest.models.Album
import com.example.androidpracticaltest.models.AlbumPhoto
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {

    @GET("albums")
    suspend fun getAlbums():Response<List<Album>>

    @GET("photos")
    suspend fun getPhotos():Response<List<AlbumPhoto>>
}