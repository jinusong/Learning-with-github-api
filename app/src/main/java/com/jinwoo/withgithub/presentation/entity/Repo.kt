package com.jinwoo.withgithub.presentation.entity

import com.jinwoo.withgithub.presentation.entity.Person

data class Repo(
    val id: Long,
    val name: String,
    val description: String? = null,
    val stargazersCount: Int,
    val language : String?,
    val owner: Person
)