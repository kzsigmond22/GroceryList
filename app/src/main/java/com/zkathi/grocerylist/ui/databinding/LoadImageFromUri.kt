package com.zkathi.grocerylist.ui.databinding

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadFromUri")
fun loadImageFromUri(imageView: ImageView, uriString: String?) {
    uriString?.let {
        if (it.isEmpty()) {
            return
        }
        val uri = Uri.parse(it)
        Glide.with(imageView.context)
            .load(uri)
            .into(imageView)
    }
}