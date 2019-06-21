package com.jinwoo.withgithub.presentation.entity

data class Auth(
    val clientId: String,
    val clientSecret: String,
    val code: String)