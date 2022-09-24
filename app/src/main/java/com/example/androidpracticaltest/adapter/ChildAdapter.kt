package com.example.androidpracticaltest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticaltest.R
import com.example.androidpracticaltest.databinding.DisplayPicturesBinding

class ChildAdapter(private val childData:List<Int>):RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = DisplayPicturesBinding.inflate(LayoutInflater.from(parent.context))
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val dataPosition = position % childData.size
        val bindingData = childData[dataPosition]
       holder.bind.displayImage.setImageResource(bindingData)
    }

    override fun getItemCount() :Int{
        return Integer.MAX_VALUE
    }

    inner class ChildViewHolder(binding: DisplayPicturesBinding): RecyclerView.ViewHolder(binding.root){
        val bind = binding
    }
}