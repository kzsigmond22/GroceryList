package com.zkathi.data.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Grocery(
    var uid: Int,
    var name: String,
    var description: String,
    var quantity: Int,
    var price: Double,
    var image_name: String,
) : Parcelable
