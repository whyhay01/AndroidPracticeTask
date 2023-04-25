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
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

@HiltViewModel
class AlbumViewModel @Inject constructor(
    repo: Repository,
) : ViewModel() {
    val albumPhoto = repo.getAlbumPhoto().asLiveData()


}