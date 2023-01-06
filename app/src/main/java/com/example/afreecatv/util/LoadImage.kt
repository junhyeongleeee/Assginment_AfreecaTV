package com.example.afreecatv.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.example.afreecatv.R

private val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

@BindingAdapter(value = ["setUrl", "setRadius"], requireAll = false)
fun ImageView.loadImage(imageUrl: String?, cornerRadius: Int?) {
    imageUrl ?: return

    Glide.with(this)
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade(factory))
        .transform(
            CenterCrop(),
            RoundedCorners(cornerRadius ?: resources.getInteger(R.integer.radius_100))
        )
        .into(this)
}