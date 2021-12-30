package com.zkathi.data.domain

import com.zkathi.data.domain.model.Grocery

interface GroceryRepository {
    suspend fun getGroceries(): List<Grocery>
    suspend fun saveGrocery(grocery: Grocery)
    suspend fun updateGrocery(grocery: Grocery)
}