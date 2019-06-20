package com.jinwoo.withgithub.domain.entity

data class TokenEntity(
        val accessToken: String,
        val scope: String,
        val tokenType: String)