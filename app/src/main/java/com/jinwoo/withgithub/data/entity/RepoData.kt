package com.jinwoo.withgithub.data.entity

import com.google.gson.annotations.SerializedName

data class RepoData(
    val id: Long,
    val name: String,
    val description: String? = null,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    val language : String?,
    val owner: PersonData
)