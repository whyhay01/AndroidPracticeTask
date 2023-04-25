package com.example.androidpracticaltest.utils

import android.util.Log
import com.example.androidpracticaltest.models.AlbumPhoto
import com.example.androidpracticaltest.models.AlbumPhotoUIObject

class DataConverter {
    private val hashMapIdWise = HashMap<Int, ArrayList<AlbumPhoto>>()

    fun convertData(albumPhotos:List<AlbumPhoto>?):List<AlbumPhotoUIObject>{
        val customResponse = ArrayList<AlbumPhotoUIObject>()

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


        hashMapIdWise.forEach {
            customResponse.add(AlbumPhotoUIObject(it.key,"Album Title ${it.key}" , it.value))
        }
        Log.d("DataConverter class", "convertData:${customResponse} ")

        return customResponse.toList()
    }
}