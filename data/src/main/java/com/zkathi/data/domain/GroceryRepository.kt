package com.zkathi.data.domain

import com.zkathi.data.domain.model.Grocery

interface GroceryRepository {
    suspend fun getGroceries(): List<Grocery>
}