package com.example.androidpracticaltest.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.androidpracticaltest.models.AlbumPhoto

class ChildComparator:DiffUtil.ItemCallback<AlbumPhoto>() {
    override fun areItemsTheSame(oldItem: AlbumPhoto, newItem: AlbumPhoto): Boolean = oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: AlbumPhoto, newItem: AlbumPhoto): Boolean  = oldItem == newItem
}