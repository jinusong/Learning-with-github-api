package com.jinwoo.withgithub.data.mapper

import com.jinwoo.withgithub.data.entity.AuthData
import com.jinwoo.withgithub.domain.entity.AuthEntity

class AuthDataMapper {
    fun mapToData(data: AuthEntity): AuthData = AuthData(
        clientId = data.clientId,
        clientSecret = data.clientSecret,
        code = data.code)
}