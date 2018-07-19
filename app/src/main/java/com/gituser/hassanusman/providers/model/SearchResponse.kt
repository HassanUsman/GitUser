package com.gituser.hassanusman.providers.model


/**
 * Created by hassanusman on 7/1/18.
 */
data class User (
        val name: String,
        val id: Long,
        val url: String,
        val bio: String,
        val location: String,
        val avatar_url: String,
        val html_url: String,
        val followers_url: String,
        val following_url: String,
        val starred_url: String,
        val gists_url: String,
        val type: String,
        val public_repos: String,
        val public_gists: String,
        val followers: String,
        val following: String,
        val created_at: String,
        val updated_at: String
)
data class Result (val total_count: Int, val incomplete_results: Boolean, val items: List<User>)

//@BindingAdapter("bind:avatar_url")
//fun loadImage(view: ImageView, imageUrl: String) {
//
//    Glide.with(view.getContext())
//            .load(imageUrl)
//            .into(view)
//}