package com.zkathi.data.domain.model

data class Grocery(
    val uid: Int,
    val name: String,
    val description: String,
    val quantity: Int,
    val price: Double,
    val image_name: String,
)
