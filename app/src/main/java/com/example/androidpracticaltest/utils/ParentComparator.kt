package com.example.androidpracticaltest.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.androidpracticaltest.models.CustomResponse

class ParentComparator : DiffUtil.ItemCallback<CustomResponse>() {
    override fun areItemsTheSame(oldItem: CustomResponse, newItem: CustomResponse): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CustomResponse, newItem: CustomResponse): Boolean = oldItem == newItem
}