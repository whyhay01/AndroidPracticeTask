package com.example.androidpracticaltest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticaltest.databinding.DisplayAlbumBinding
import com.example.androidpracticaltest.models.CustomResponse
import com.example.androidpracticaltest.sampleData.ParentItem

class ParentAdapter(var parentData: List<CustomResponse>) :
    RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = DisplayAlbumBinding.inflate(LayoutInflater.from(parent.context))
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val dataPosition = position % parentData.size
        val data: CustomResponse = parentData[dataPosition]
        holder.bindView(data)
    }

    override fun getItemCount(): Int = Integer.MAX_VALUE

    inner class ParentViewHolder(binding: DisplayAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val bind = binding

        fun bindView(bindingData: CustomResponse) {
            bind.apply {
                title.text = bindingData.title

                pictureRv.apply {
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = ChildAdapter(bindingData.albumPhotos)
                    scrollToPosition(Integer.MAX_VALUE)
                }
            }

        }

    }
}