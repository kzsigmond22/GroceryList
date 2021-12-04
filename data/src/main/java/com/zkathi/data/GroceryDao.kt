package com.zkathi.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GroceryDao {

    @Query("SELECT * FROM groceryentity")
    suspend fun getAll(): List<GroceryEntity>

    @Insert
    suspend fun insertAll(vararg groceryEntity: GroceryEntity)

    @Delete
    suspend fun delete(groceryEntity: GroceryEntity)
}