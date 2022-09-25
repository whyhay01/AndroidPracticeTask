package com.example.androidpracticaltest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidpracticaltest.models.AlbumPhoto
import com.example.androidpracticaltest.models.CustomResponse
import com.example.androidpracticaltest.repository.Repository
import com.example.androidpracticaltest.utils.DataConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val repo: Repository, private val converter: DataConverter): ViewModel() {
    private val _albumPhoto: MutableLiveData<List<CustomResponse>> =  MutableLiveData()
    val albumPhoto:LiveData<List<CustomResponse>>
        get() = _albumPhoto

    fun getAlbumPhotos(){

        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO){
                    repo.getPhotos().collect{

                        Log.d("AlbumViewModel", "getAlbumPhotos: ${it[1]} ")
                        _albumPhoto.postValue(converter.convertData(it))
                    }
                }
            }catch (e:Exception){
                Log.d("AlbumViewModel", "getAlbumPhotos: $e")
            }
        }
    }
}