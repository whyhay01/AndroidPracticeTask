package com.example.androidpracticaltest.viewmodel

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

@HiltViewModel
class AlbumViewModel @Inject constructor(
    repo: Repository,
) : ViewModel() {

    val albumPhoto: LiveData<Resource<List<AlbumPhoto>>> = repo.getAlbumPhoto().asLiveData()

//    private val _albumPhotos: MutableStateFlow<Resource<List<AlbumPhoto>>?> = MutableStateFlow(null)
//    val albumPhotos = _albumPhotos.asStateFlow()
//
//    fun getAlbumPhotos(){
//
//    }

//    private val _albumPhoto: MutableLiveData<List<CustomResponse>> =  MutableLiveData()
//    val albumPhoto:LiveData<List<CustomResponse>>
//        get() = _albumPhoto
//
//    fun getAlbumPhotos(){
//
//        viewModelScope.launch {
//            try {
//                withContext(Dispatchers.IO){
//                    repo.getPhotos().collect{
//
//                        Log.d("AlbumViewModel", "getAlbumPhotos: ${it[1]} ")
//                        _albumPhoto.postValue(converter.convertData(it))
//                    }
//                }
//            }catch (e:Exception){
//                Log.d("AlbumViewModel", "getAlbumPhotos: $e")
//            }
//        }
//    }
}