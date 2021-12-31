package com.zkathi.grocerylist.ui.databinding

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.zkathi.grocerylist.R

@BindingAdapter("loadFromUri")
fun loadImageFromUri(imageView: ImageView, uriString: String?) {
    uriString?.let {
        if (it.isNotEmpty()) {
            val uri = Uri.parse(it)
            Glide.with(imageView.context)
                .load(uri)
                .error(R.drawable.ic_baseline_image_24)
                .into(imageView)
        } else {
            Glide.with(imageView.context)
                .load(R.drawable.ic_baseline_image_24)
                .into(imageView)
        }
    }
}