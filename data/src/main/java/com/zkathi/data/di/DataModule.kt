package com.zkathi.data.di

import com.zkathi.data.data.GroceryRepositoryImpl
import com.zkathi.data.domain.GroceryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DataModule {

    @Binds
    fun bindGroceryRepository(groceryRepositoryImpl: GroceryRepositoryImpl): GroceryRepository

}