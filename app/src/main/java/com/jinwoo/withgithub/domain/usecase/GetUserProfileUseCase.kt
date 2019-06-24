package com.jinwoo.withgithub.domain.usecase

import com.jinwoo.withgithub.domain.base.UseCase
import com.jinwoo.withgithub.domain.entity.ProfileEntity
import com.jinwoo.withgithub.domain.repository.user.UserRepository
import io.reactivex.Flowable

class GetUserProfileUseCase(val repository: UserRepository): UseCase<String, ProfileEntity>() {
    override fun createSingle(data: String): Flowable<ProfileEntity>
            = repository.getUserProfile(data)

    fun getUserProfile(userName:String)
            = createSingle(userName)
}