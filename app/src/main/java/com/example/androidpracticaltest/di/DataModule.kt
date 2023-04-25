package com.example.androidpracticaltest.di

import android.content.Context
import androidx.room.Room
import com.example.androidpracticaltest.db.AlbumPhotoDao
import com.example.androidpracticaltest.db.AppDatabase
import com.example.androidpracticaltest.utils.DataConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext:Context):AppDatabase{

        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "Application data"
        ).build()
    }


    @Provides
    fun provideDataConvert():DataConverter{
        return DataConverter()
    }

    @Provides
    fun provideAlbumPhotoDao(appDatabase: AppDatabase):AlbumPhotoDao{
        return appDatabase.albumPhotoDao()
    }
}