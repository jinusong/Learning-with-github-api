package com.jinwoo.withgithub.data.datasource

import com.jinwoo.withgithub.data.entity.AuthData
import com.jinwoo.withgithub.data.entity.TokenData
import com.jinwoo.withgithub.domain.entity.TokenEntity
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.Response

interface AuthDataSource {
    fun getLocalToken(authData: AuthData): String?

    fun getRemoteToken(authData: AuthData): Flowable<TokenData>

    fun saveLocalToken(token: String)
}