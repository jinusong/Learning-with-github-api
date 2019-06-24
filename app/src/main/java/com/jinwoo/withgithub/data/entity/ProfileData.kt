package com.jinwoo.withgithub.data.entity

import com.google.gson.annotations.SerializedName

data class ProfileData(
    @SerializedName("name")
    val name: String,
    @SerializedName("company")
    val company: String,
    @SerializedName("blog")
    val blog: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("followers")
    val followers: String,
    @SerializedName("following")
    val following: String
)