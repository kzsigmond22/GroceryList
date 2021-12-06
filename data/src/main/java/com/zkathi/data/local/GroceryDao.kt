package com.zkathi.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.zkathi.data.local.entity.GroceryEntity

@Dao
interface GroceryDao {

    @Query("SELECT * FROM groceryentity")
    suspend fun getAll(): List<GroceryEntity>

    @Insert
    suspend fun insertAll(vararg groceryEntity: GroceryEntity)

    @Delete
    suspend fun delete(groceryEntity: GroceryEntity)
}