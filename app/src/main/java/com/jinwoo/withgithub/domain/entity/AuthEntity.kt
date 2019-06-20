package com.jinwoo.withgithub.domain.entity

data class AuthEntity(
    val clientId: String,
    val clientSecret: String,
    val code: String)