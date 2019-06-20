package com.jinwoo.withgithub.data.entity

import com.google.gson.annotations.SerializedName

data class TokenData(
    @SerializedName("access_token") val accessToken: String,
    val scope: String,
    @SerializedName("token_type") val tokenType: String)