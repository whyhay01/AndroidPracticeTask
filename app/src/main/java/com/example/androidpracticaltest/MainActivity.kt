package com.example.androidpracticaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpracticaltest.adapter.ParentAdapter
import com.example.androidpracticaltest.databinding.ActivityMainBinding
import com.example.androidpracticaltest.sampleData.parentItemList
import com.example.androidpracticaltest.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val mViewModel: AlbumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mViewModel.getAlbumPhotos()

        binding.apply {
            mViewModel.albumPhoto.observe(this@MainActivity) { data ->
                Log.d("MainActivity", "onCreate: ${data[1].albumPhotos}")
                parentRV.adapter = ParentAdapter(data)
                parentRV.layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                parentRV.scrollToPosition(Integer.MAX_VALUE / 2)
                parentRV.adapter?.notifyDataSetChanged()
            }

        }
    }
}