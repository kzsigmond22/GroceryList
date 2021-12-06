package com.zkathi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zkathi.data.local.entity.GroceryEntity

@Database(entities = [GroceryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun groceryDao(): GroceryDao
}