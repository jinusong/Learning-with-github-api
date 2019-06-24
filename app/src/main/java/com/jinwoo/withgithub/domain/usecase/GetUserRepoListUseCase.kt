package com.jinwoo.withgithub.domain.usecase

import com.jinwoo.withgithub.domain.entity.RepoEntity
import com.jinwoo.withgithub.domain.base.UseCase
import com.jinwoo.withgithub.domain.repository.user.UserRepository
import io.reactivex.Flowable

class GetUserRepoListUseCase(val repository: UserRepository): UseCase<String, ArrayList<RepoEntity>>() {
    override fun createSingle(data: String): Flowable<ArrayList<RepoEntity>>
            = repository.getUserRepoList(data)

    fun getUserRepoList(userName: String)
            = createSingle(userName)
}