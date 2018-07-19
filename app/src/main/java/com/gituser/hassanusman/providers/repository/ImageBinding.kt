package com.gituser.hassanusman.providers.repository

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


@BindingAdapter("bind:avatar_url")
fun loadImage(view: ImageView, url: String?) {
    Glide.with(view).load(url).into(view)
}

 @BindingAdapter("bind:visibleView")
fun View.visibleOrGone(visible: Boolean) {
     visibility = if (visible) View.VISIBLE else View.GONE
 }




/*
data class ImageBinding {

    @BindingAdapter("bind:imageUrl")

    //    @BindingAdapter("bind:visibilityOnIndex")
    fun toggleVisibility(view: View, index: Int) {
        view.setVisibility(if (index > 0) View.VISIBLE else View.GONE)
    }
}*/
