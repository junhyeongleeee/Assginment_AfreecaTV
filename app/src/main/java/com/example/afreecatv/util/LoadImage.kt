package com.example.afreecatv.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

private val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

@BindingAdapter("setRequestManager", "setUrl")
fun ImageView.loadImage(requestManager: RequestManager, imageUrl: String?) {
    imageUrl ?: return

    Log.d("ImageView", "loadImage: $imageUrl")
    requestManager
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade(factory))
        .transform(CenterCrop(), RoundedCorners(10))
        .into(this)
}