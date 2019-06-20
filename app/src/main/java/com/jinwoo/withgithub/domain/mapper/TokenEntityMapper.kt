package com.jinwoo.withgithub.domain.mapper

import com.jinwoo.withgithub.data.entity.TokenData
import com.jinwoo.withgithub.domain.entity.TokenEntity

class TokenEntityMapper {
    fun mapToEntity(data: TokenData): TokenEntity = TokenEntity(
        accessToken = data.accessToken,
        scope = data.scope,
        tokenType = data.tokenType)
}