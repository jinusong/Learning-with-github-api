package com.jinwoo.withgithub.data.entity

data class RepoEntity(
    val id: Long,
    val name: String,
    val description: String? = null,
    val stargazersCount: Int,
    val language : String?,
    val owner: Person
)