package com.example.androidpracticaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpracticaltest.adapter.ParentAdapter
import com.example.androidpracticaltest.databinding.ActivityMainBinding
import com.example.androidpracticaltest.models.AlbumPhotoUIObject
import com.example.androidpracticaltest.utils.DataConverter
import com.example.androidpracticaltest.utils.Resource
import com.example.androidpracticaltest.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val mViewModel: AlbumViewModel by viewModels()
    private val converter= DataConverter()
    private var parentAdapter:ParentAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //ViewModel
        mViewModel.getAlbumPhotos()


        //ViewModelObserver
        observeViewModel()

        implementRecyclerView()
    }

    private fun observeViewModel(){
        lifecycleScope.launch {

            mViewModel.albumPhoto.flowWithLifecycle(lifecycle,Lifecycle.State.STARTED).collect{ result ->

                val bindingData: List<AlbumPhotoUIObject> = converter.convertData(result?.data)
                parentAdapter = ParentAdapter(bindingData)
                binding.parentRV.adapter?.notifyDataSetChanged()
//                binding.parentRV.apply {
//
//                    adapter = ParentAdapter(bindingData)
//                    layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL, false)
//                    scrollToPosition(Integer.MAX_VALUE)
//                }


                binding.progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                binding.errorMessage.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                binding.errorMessage.text =  result?.error?.localizedMessage

            }
        }
    }

    private fun implementRecyclerView(){
        binding.parentRV.apply {
            adapter = parentAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            scrollToPosition(Integer.MAX_VALUE)
//            adapter?.notifyDataSetChanged()

        }


    }

}