package com.jinwoo.withgithub.domain.usecase

import com.jinwoo.withgithub.domain.base.UseCase
import com.jinwoo.withgithub.domain.entity.AuthEntity
import com.jinwoo.withgithub.domain.entity.TokenEntity
import com.jinwoo.withgithub.domain.repository.auth.AuthRepository
import io.reactivex.Flowable

class AuthUseCase(val repository: AuthRepository): UseCase<AuthEntity, TokenEntity>(){

    override fun createSingle(data: AuthEntity): Flowable<TokenEntity>
            = repository.getAccessToken(data)

    fun getAuth(entity: AuthEntity): Flowable<TokenEntity>
            = createSingle(entity)
}