package com.zkathi.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GroceryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun groceryDao(): GroceryDao
}