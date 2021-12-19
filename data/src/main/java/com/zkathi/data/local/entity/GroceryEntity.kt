package com.zkathi.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GroceryEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "name") @NonNull val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "quantity") val quantity: Int,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "image_name") val image_name: String,
)
