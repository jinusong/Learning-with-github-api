package com.jinwoo.withgithub.data.entity

import com.google.gson.annotations.SerializedName

data class PersonData(
    val id: Long,
    val name: String?,
    val company : String?,
    val login : String,
    val location : String?,
    val email : String?,
    @SerializedName("avatar_url")val avatar: String
)