package com.example.androidpracticaltest.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.androidpracticaltest.models.AlbumPhotoUIObject

class ParentComparator : DiffUtil.ItemCallback<AlbumPhotoUIObject>() {
    override fun areItemsTheSame(oldItem: AlbumPhotoUIObject, newItem: AlbumPhotoUIObject): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: AlbumPhotoUIObject, newItem: AlbumPhotoUIObject): Boolean = oldItem == newItem
}