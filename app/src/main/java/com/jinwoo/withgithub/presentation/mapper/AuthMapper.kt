package com.jinwoo.withgithub.presentation.mapper

import com.jinwoo.withgithub.domain.base.Mapper
import com.jinwoo.withgithub.domain.entity.AuthEntity
import com.jinwoo.withgithub.presentation.entity.Auth

class AuthMapper: Mapper<Auth, AuthEntity> {

    override fun mapFrom(from: Auth): AuthEntity = AuthEntity(
        clientId = from.clientId,
        clientSecret = from.clientSecret,
        code = from.code)
}