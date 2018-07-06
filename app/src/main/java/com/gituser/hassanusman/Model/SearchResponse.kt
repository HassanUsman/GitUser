package com.gituser.hassanusman.Model

import com.google.gson.annotations.SerializedName
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide


/**
 * Created by hassanusman on 7/1/18.
 */
data class userInfo (
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
data class User (

        @SerializedName("login") val login : String,
        @SerializedName("id") val id : Int,
        @SerializedName("node_id") val node_id : String,
        @SerializedName("avatar_url") val avatar_url : String,
        @SerializedName("gravatar_id") val gravatar_id : String,
        @SerializedName("url") val url : String,
        @SerializedName("html_url") val html_url : String,
        @SerializedName("followers_url") val followers_url : String,
        @SerializedName("following_url") val following_url : String,
        @SerializedName("gists_url") val gists_url : String,
        @SerializedName("starred_url") val starred_url : String,
        @SerializedName("subscriptions_url") val subscriptions_url : String,
        @SerializedName("organizations_url") val organizations_url : String,
        @SerializedName("repos_url") val repos_url : String,
        @SerializedName("events_url") val events_url : String,
        @SerializedName("received_events_url") val received_events_url : String,
        @SerializedName("type") val type : String,
        @SerializedName("site_admin") val site_admin : Boolean,
        @SerializedName("name") val name : String,
        @SerializedName("company") val company : String,
        @SerializedName("blog") val blog : String,
        @SerializedName("location") val location : String,
        @SerializedName("email") val email : String,
        @SerializedName("hireable") val hireable : Boolean,
        @SerializedName("bio") val bio : String,
        @SerializedName("public_repos") val public_repos : Int,
        @SerializedName("public_gists") val public_gists : Int,
        @SerializedName("followers") val followers : Int,
        @SerializedName("following") val following : Int,
        @SerializedName("created_at") val created_at : String,
        @SerializedName("updated_at") val updated_at : String
)

data class Result (val total_count: Int, val incomplete_results: Boolean, val items: List<User>)

@BindingAdapter("bind:avatar_url")
fun loadImage(view: ImageView, imageUrl: String) {

    Glide.with(view.getContext())
            .load(imageUrl)
            .into(view)
}