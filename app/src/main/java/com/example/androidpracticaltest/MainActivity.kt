package com.example.androidpracticaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpracticaltest.adapter.ParentAdapter
import com.example.androidpracticaltest.databinding.ActivityMainBinding
import com.example.androidpracticaltest.sampleData.parentItemList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            parentRV.adapter = ParentAdapter(parentItemList)
            parentRV.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
            parentRV.scrollToPosition(Integer.MAX_VALUE/2)
            parentRV.adapter?.notifyDataSetChanged()
        }
    }
}