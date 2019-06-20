package com.jinwoo.withgithub.data.datasource

import android.util.Log
import com.jinwoo.withgithub.data.entity.AuthData
import com.jinwoo.withgithub.data.entity.TokenData
import com.jinwoo.withgithub.data.repository.AuthLocal
import com.jinwoo.withgithub.data.repository.AuthRemote
import io.reactivex.Flowable
import io.reactivex.Single

class AuthDataSourceImpl(val remote: AuthRemote, val local: AuthLocal): AuthDataSource {
    override fun getLocalToken(authData: AuthData): String? = local.getToken()

    override fun saveLocalToken(token: String) = local.saveToken(token)

    override fun getRemoteToken(authData: AuthData): Flowable<TokenData>
            = remote.getAccessToken(authData)
}