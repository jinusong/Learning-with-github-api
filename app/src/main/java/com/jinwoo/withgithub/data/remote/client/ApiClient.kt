package com.jinwoo.withgithub.data.remote.client

import com.jinwoo.withgithub.data.entity.PersonData
import com.jinwoo.withgithub.data.entity.ProfileData
import com.jinwoo.withgithub.data.entity.RepoData
import com.jinwoo.withgithub.data.remote.api.Api
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiClient(val api: Api) {
    fun getUserRepoList(userName: String): Flowable<ArrayList<RepoData>> =
        api.getUserRepoList(userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getUserProfile(userName: String): Flowable<ProfileData> =
        api.getUserProfile(userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getUserFollowerList(userName: String): Flowable<ArrayList<PersonData>> =
        api.getUserFollowerList(userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getUserFollowingList(userName: String): Flowable<ArrayList<PersonData>> =
        api.getUserFollowingList(userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}