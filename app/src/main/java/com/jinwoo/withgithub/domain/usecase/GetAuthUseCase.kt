package com.jinwoo.withgithub.domain.usecase

import com.jinwoo.withgithub.domain.base.UseCase
import com.jinwoo.withgithub.domain.entity.AuthEntity
import com.jinwoo.withgithub.domain.entity.TokenEntity
import com.jinwoo.withgithub.domain.repository.auth.AuthRepository
import io.reactivex.Flowable

class GetAuthUseCase(val repository: AuthRepository): UseCase<AuthEntity, TokenEntity>(){

    override fun createSingle(entity: AuthEntity): Flowable<TokenEntity>
            = repository.getAccessToken(entity)

    fun getAuth(entity: AuthEntity): Flowable<TokenEntity>
            = createSingle(entity)
}