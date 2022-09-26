package com.example.androidpracticaltest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.androidpracticaltest.models.AlbumPhoto
import com.example.androidpracticaltest.repository.Repository
import com.example.androidpracticaltest.utils.DataConverter
import com.example.androidpracticaltest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import androidx.lifecycle.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val repo: Repository,
) : ViewModel() {

    private val _albumPhoto: MutableStateFlow<Resource<List<AlbumPhoto>>?> = MutableStateFlow(null)
    val albumPhoto = _albumPhoto.asStateFlow()

    fun getAlbumPhotos(){
        viewModelScope.launch {
           repo.getAlbumPhoto().collect{
               _albumPhoto.value = it

               Log.d("AlbumViewModel", "getAlbumPhotos: $it")
           }
        }
    }

}