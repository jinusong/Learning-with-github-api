package com.jinwoo.withgithub.data.datasource.user

import com.jinwoo.withgithub.data.entity.PersonData
import com.jinwoo.withgithub.data.entity.ProfileData
import com.jinwoo.withgithub.data.entity.RepoData
import com.jinwoo.withgithub.data.local.user.UserLocal
import com.jinwoo.withgithub.data.remote.user.UserRemote
import io.reactivex.Flowable

class UserDataSourceImpl(val remote: UserRemote, val local: UserLocal):UserDataSource {
    override fun getRemoteUserRepoList(userName: String): Flowable<ArrayList<RepoData>>
            = remote.getUserRepoList(userName)

    override fun getRemoteUserFollowerList(userName: String): Flowable<ArrayList<PersonData>>
            = remote.getUserFollowerList(userName)

    override fun getRemoteUserFollowingList(userName: String): Flowable<ArrayList<PersonData>>
            = remote.getUserFollowingList(userName)

    override fun getRemoteUserProfile(userName: String): Flowable<ProfileData>
            = remote.getUserProfile(userName)
}