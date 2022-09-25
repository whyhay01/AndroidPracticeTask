package com.example.androidpracticaltest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.androidpracticaltest.R
import com.example.androidpracticaltest.databinding.DisplayPicturesBinding
import com.example.androidpracticaltest.models.AlbumPhoto

class ChildAdapter(private val childData:List<AlbumPhoto>):RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = DisplayPicturesBinding.inflate(LayoutInflater.from(parent.context))
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val dataPosition = position % childData.size
        val bindingData: AlbumPhoto = childData[dataPosition]
        holder.bindView(bindingData)


//        Glide.with(holder.bind.root.context)
//            .load(bindingData.thumbnailUrl)
//            .placeholder(R.drawable.image_four)
//            .into(holder.bind.displayImage)
//
////       holder.bind.displayImage.apply {
////
////       }
    }

    override fun getItemCount() :Int = Integer.MAX_VALUE

    inner class ChildViewHolder(binding: DisplayPicturesBinding): RecyclerView.ViewHolder(binding.root){
        private val bind = binding

        fun bindView(bindingData:AlbumPhoto){
            bind.apply {

                displayImage.load(bindingData.imageUrl){
                    error(R.drawable.ic_baseline_error_outline_24)
                    placeholder(R.drawable.image_four)
                    size(150,150)
                }

//                Glide.with(itemView)
//                    .load( "https://via.placeholder.com/150/b6823f")
//                    .error(R.drawable.image_four)
//                    .override(150,150)
//                    .into(displayImage)
            }
        }
    }
}