package com.jinwoo.withgithub.data.datasource.auth

import com.jinwoo.withgithub.data.entity.AuthData
import com.jinwoo.withgithub.data.entity.TokenData
import com.jinwoo.withgithub.data.local.auth.AuthLocal
import com.jinwoo.withgithub.data.remote.auth.AuthRemote
import io.reactivex.Flowable

class AuthDataSourceImpl(val remote: AuthRemote, val local: AuthLocal):
    AuthDataSource {
    override fun getLocalToken(authData: AuthData): String? = local.getToken()

    override fun saveLocalToken(token: String) = local.saveToken(token)

    override fun getRemoteToken(authData: AuthData): Flowable<TokenData>
            = remote.getAccessToken(authData)
}