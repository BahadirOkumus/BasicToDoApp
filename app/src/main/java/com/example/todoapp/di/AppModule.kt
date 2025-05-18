package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.datasource.GorevlerDataSource
import com.example.todoapp.data.repo.GorevlerRepository
import com.example.todoapp.room.GorevlerDao
import com.example.todoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideGorevlerRepository(gorevlerDataSource: GorevlerDataSource) : GorevlerRepository{
        return GorevlerRepository(gorevlerDataSource)
    }
    @Provides
    @Singleton
    fun provideGorevlerDataSource(gorevlerDao: GorevlerDao) : GorevlerDataSource{
        return GorevlerDataSource(gorevlerDao)
    }
    @Provides
    @Singleton
    fun provideGorevlerDao(@ApplicationContext context: Context) : GorevlerDao {
        val veritabani = Room.databaseBuilder(context, Veritabani::class.java,"gorevler.sqlite")
            .createFromAsset("gorevler.sqlite")
            .build()

        return veritabani.getGorevlerDao()

    }
}