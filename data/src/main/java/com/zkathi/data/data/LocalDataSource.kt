package com.zkathi.data.data

import com.zkathi.data.domain.model.Grocery

interface LocalDataSource {
    suspend fun getAllGroceries(): List<Grocery>
    suspend fun saveGrocery(grocery: Grocery)
    suspend fun updateGrocery(grocery: Grocery)
    suspend fun deleteGrocery(grocery: Grocery)
}