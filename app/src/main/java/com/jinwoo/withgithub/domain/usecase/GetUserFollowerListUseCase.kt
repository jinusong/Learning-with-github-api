package com.jinwoo.withgithub.domain.usecase

import com.jinwoo.withgithub.domain.entity.RepoEntity
import com.jinwoo.withgithub.domain.base.UseCase
import com.jinwoo.withgithub.domain.entity.PersonEntity
import com.jinwoo.withgithub.domain.repository.user.UserRepository
import io.reactivex.Flowable

class GetUserFollowerListUseCase(val repository: UserRepository): UseCase<String, ArrayList<PersonEntity>>() {
    override fun createSingle(data: String): Flowable<ArrayList<PersonEntity>>
            = repository.getUserFollowerList(data)

    fun getUserFollowerList(userName: String)
            = createSingle(userName)
}