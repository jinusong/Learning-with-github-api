package com.jinwoo.withgithub.domain.repository.user

import com.jinwoo.withgithub.domain.entity.PersonEntity
import com.jinwoo.withgithub.domain.entity.ProfileEntity
import com.jinwoo.withgithub.domain.entity.RepoEntity
import io.reactivex.Flowable

interface UserRepository {
    fun getUserRepoList(userName: String): Flowable<ArrayList<RepoEntity>>

    fun getUserFollowerList(userName: String): Flowable<ArrayList<PersonEntity>>

    fun getUserFollowingList(userName: String): Flowable<ArrayList<PersonEntity>>

    fun getUserProfile(userName: String): Flowable<ProfileEntity>
}