package com.jinwoo.withgithub.data.datasource.user

import com.jinwoo.withgithub.data.entity.PersonData
import com.jinwoo.withgithub.data.entity.ProfileData
import com.jinwoo.withgithub.data.entity.RepoData
import io.reactivex.Flowable

interface UserDataSource {
    fun getRemoteUserRepoList(userName: String): Flowable<ArrayList<RepoData>>

    fun getRemoteUserFollowerList(userName: String): Flowable<ArrayList<PersonData>>

    fun getRemoteUserFollowingList(userName: String): Flowable<ArrayList<PersonData>>

    fun getRemoteUserProfile(userName: String): Flowable<ProfileData>
}