package com.example.androidpracticaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpracticaltest.adapter.ParentAdapter
import com.example.androidpracticaltest.databinding.ActivityMainBinding
import com.example.androidpracticaltest.utils.DataConverter
import com.example.androidpracticaltest.utils.Resource
import com.example.androidpracticaltest.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val mViewModel: AlbumViewModel by viewModels()
    private val converter= DataConverter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        mViewModel.getAlbumPhotos()

        binding.apply {
            mViewModel.albumPhoto.observe(this@MainActivity) { result ->

                val bindingData = converter.convertData(result.data)

                Log.d("MainActivity", "onCreate: ${bindingData[1]}")


                ParentAdapter().submitList(bindingData)
                parentRV.adapter = ParentAdapter()
                parentRV.layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//                parentRV.scrollToPosition(Integer.MAX_VALUE / 2)
                parentRV.adapter?.notifyDataSetChanged()



                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                errorMessage.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                errorMessage.text =  result.error?.localizedMessage
            }

        }
    }
}