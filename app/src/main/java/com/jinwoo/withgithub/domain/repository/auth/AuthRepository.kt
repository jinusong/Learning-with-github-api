package com.jinwoo.withgithub.domain.repository.auth

import com.jinwoo.withgithub.domain.entity.AuthEntity
import com.jinwoo.withgithub.domain.entity.TokenEntity
import io.reactivex.Flowable
import io.reactivex.Single

interface AuthRepository {
    fun getAccessToken(authEntity: AuthEntity): Flowable<TokenEntity>
}