package com.jinwoo.withgithub.data.entity

import com.google.gson.annotations.SerializedName

data class PersonEntity(
    val id: Long,
    val name: String?,
    val company : String?,
    val login : String,
    val location : String?,
    val email : String?,
    val avatar: String
)