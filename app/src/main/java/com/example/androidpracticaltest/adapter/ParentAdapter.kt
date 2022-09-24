package com.example.androidpracticaltest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpracticaltest.databinding.DisplayAlbumBinding
import com.example.androidpracticaltest.sampleData.ParentItem

class ParentAdapter(var parentData: List<ParentItem>) :
    RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = DisplayAlbumBinding.inflate(LayoutInflater.from(parent.context))
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val dataPosition = position % parentData.size
        val data = parentData[dataPosition]

        holder.bind.title.text = data.title

        holder.bind.apply {
            pictureRv.layoutManager =
                LinearLayoutManager(holder.bind.root.context, LinearLayoutManager.HORIZONTAL, false)
            pictureRv.adapter = ChildAdapter(data.childList)
            pictureRv.scrollToPosition(Integer.MAX_VALUE/2)


        }
    }

    override fun getItemCount(): Int {
        return Integer.MAX_VALUE
    }

    inner class ParentViewHolder(binding: DisplayAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val bind = binding

    }
}