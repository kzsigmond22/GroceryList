package com.zkathi.data.local

import androidx.room.*
import com.zkathi.data.local.entity.GroceryEntity

@Dao
interface GroceryDao {

    @Query("SELECT * FROM groceryentity ORDER BY quantity ASC, name ASC")
    suspend fun getAll(): List<GroceryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg groceryEntity: GroceryEntity)

    @Delete
    suspend fun delete(groceryEntity: GroceryEntity)

    @Update
    suspend fun update(groceryEntity: GroceryEntity)
}