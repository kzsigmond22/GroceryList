package com.zkathi.grocerylist.ui.databinding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.zkathi.data.domain.model.Grocery
import com.zkathi.grocerylist.R

@BindingAdapter("colorIndicator")
fun getColorIndicator(imageView: View, groceryQuantity: Int) {
    val context = imageView.context
    when (groceryQuantity) {
        0 -> imageView.setBackgroundColor(context.getColor(R.color.grocery_0))
        1 -> imageView.setBackgroundColor(context.getColor(R.color.grocery_1))
        else -> imageView.setBackgroundColor(context.getColor(R.color.grocery_more_than_1))
    }
}