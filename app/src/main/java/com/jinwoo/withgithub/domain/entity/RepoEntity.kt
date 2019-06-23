package com.jinwoo.withgithub.domain.entity

data class RepoEntity(
    val id: Long,
    val name: String,
    val description: String? = null,
    val stargazersCount: Int,
    val language : String?,
    val owner: PersonEntity
)