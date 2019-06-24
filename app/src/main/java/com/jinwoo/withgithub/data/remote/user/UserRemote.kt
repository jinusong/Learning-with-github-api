package com.jinwoo.withgithub.data.remote.user

import com.jinwoo.withgithub.data.entity.PersonData
import com.jinwoo.withgithub.data.entity.ProfileData
import com.jinwoo.withgithub.data.entity.RepoData
import com.jinwoo.withgithub.data.remote.client.ApiClient
import io.reactivex.Flowable

class UserRemote(val apiClient: ApiClient) {
    fun getUserRepoList(userName: String): Flowable<ArrayList<RepoData>>
            = apiClient.getUserRepoList(userName)

    fun getUserFollowerList(userName: String): Flowable<ArrayList<PersonData>>
            = apiClient.getUserFollowerList(userName)

    fun getUserFollowingList(userName: String): Flowable<ArrayList<PersonData>>
            = apiClient.getUserFollowingList(userName)

    fun getUserProfile(userName: String): Flowable<ProfileData>
            = apiClient.getUserProfile(userName)
}