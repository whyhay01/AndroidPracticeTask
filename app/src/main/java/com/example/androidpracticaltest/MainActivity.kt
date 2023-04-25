package com.example.androidpracticaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
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
    private val mViewModel by lazy {
        ViewModelProvider(this).get(AlbumViewModel::class.java)
    }

    private val converter = DataConverter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            parentRV.apply {
                mViewModel.albumPhoto.observe(this@MainActivity) { result ->
                    if (result is Resource.Success || result.data!!.isNotEmpty()) {
                        val bindingData: List<AlbumPhotoUIObject> = converter.convertData(result.data)
                        adapter = ParentAdapter(bindingData)
                        scrollToPosition(Integer.MAX_VALUE / 2)
                    }

                    progressBar.isVisible =
                        result is Resource.Loading && result.data.isNullOrEmpty()
                    errorMessage.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                    errorMessage.text = result?.error?.localizedMessage
                }
            }
        }

    }

}