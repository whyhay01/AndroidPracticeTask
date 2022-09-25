package com.example.androidpracticaltest.utils

import android.util.Log
import com.example.androidpracticaltest.models.AlbumPhoto
import com.example.androidpracticaltest.models.CustomResponse

class DataConverter {
    private val hashMapIdWise = HashMap<Int, ArrayList<AlbumPhoto>>()

    fun convertData(albumPhotos:List<AlbumPhoto>?):List<CustomResponse>{
        val customResponse = ArrayList<CustomResponse>()

        albumPhotos?.forEach { albumPhoto ->
            if (hashMapIdWise.contains(albumPhoto.albumId)){
                val list = hashMapIdWise[albumPhoto.albumId]

                list!!.add(albumPhoto)

                hashMapIdWise[albumPhoto.albumId] = list
            }else{
                val consolidateList = ArrayList<AlbumPhoto>()

                consolidateList.add(albumPhoto)
                hashMapIdWise[albumPhoto.albumId] = consolidateList
            }
        }
        Log.d("DataConverter class", "convertData:${hashMapIdWise} ")

        hashMapIdWise.forEach {
            customResponse.add(CustomResponse(it.key,"Album Title ${it.key}" , it.value))
        }

        return customResponse.toList()
    }
}