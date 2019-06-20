package com.jinwoo.withgithub.data.mapper

import com.jinwoo.withgithub.data.entity.TokenData
import com.jinwoo.withgithub.domain.entity.TokenEntity

class TokenDataMapper {
    fun mapToData(data: TokenEntity): TokenData = TokenData(
        accessToken = data.accessToken,
        scope = data.scope,
        tokenType = data.tokenType)
}