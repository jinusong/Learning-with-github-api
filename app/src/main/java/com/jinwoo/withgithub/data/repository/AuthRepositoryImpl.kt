package com.jinwoo.withgithub.data.repository

import android.media.session.MediaSession
import com.jinwoo.withgithub.data.datasource.AuthDataSource
import com.jinwoo.withgithub.data.entity.TokenData
import com.jinwoo.withgithub.data.mapper.AuthDataMapper
import com.jinwoo.withgithub.domain.entity.AuthEntity
import com.jinwoo.withgithub.domain.entity.TokenEntity
import com.jinwoo.withgithub.domain.mapper.TokenEntityMapper
import com.jinwoo.withgithub.domain.repository.auth.AuthRepository
import io.reactivex.Flowable

class AuthRepositoryImpl(val authDataSource: AuthDataSource): AuthRepository {

    private val authDataMapper =  AuthDataMapper()
    private val tokenEntityMapper = TokenEntityMapper()

    override fun getAccessToken(authEntity: AuthEntity): Flowable<TokenEntity> = getRemoteTokenData(authEntity).map {
            saveLocalToken(it)
            tokenEntityMapper.mapToEntity(it)
    }

    private fun saveLocalToken(tokenData: TokenData) =
        authDataSource.saveLocalToken(tokenData.accessToken)

    private fun getRemoteTokenData(authEntity: AuthEntity): Flowable<TokenData> =
        authDataSource.getRemoteToken(authDataMapper.mapToData(authEntity))

    private fun getLocalToken(authEntity: AuthEntity): String? =
        authDataSource.getLocalToken(authDataMapper.mapToData(authEntity))
}