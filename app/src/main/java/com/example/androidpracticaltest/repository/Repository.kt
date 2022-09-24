package com.example.androidpracticaltest.repository

import com.example.androidpracticaltest.db.AppDatabase
import com.example.androidpracticaltest.network.NetworkService
import javax.inject.Inject

class Repository @Inject constructor(
    private val service: NetworkService,
    private val db: AppDatabase
) {
}