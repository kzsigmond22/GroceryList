package com.zkathi.data.di

import android.content.Context
import androidx.room.Room
import com.zkathi.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()

    @Provides
    @Singleton
    fun provideGroceryDao(appDatabase: AppDatabase) = appDatabase.groceryDao()
}