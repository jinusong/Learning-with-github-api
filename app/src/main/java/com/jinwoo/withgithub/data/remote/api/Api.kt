package com.jinwoo.withgithub.data.remote.api

import com.jinwoo.withgithub.data.entity.PersonData
import com.jinwoo.withgithub.data.entity.ProfileData
import com.jinwoo.withgithub.data.entity.RepoData
import com.jinwoo.withgithub.presentation.entity.Person
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{userName}")
    fun getUserProfile(@Path("userName")userName : String):Flowable<ProfileData>

    @GET("users/{userName}/repos")
    fun getUserRepoList(@Path("userName")userName : String):Flowable<ArrayList<RepoData>>

    @GET("users/{userName}/followers")
    fun getUserFollowerList(@Path("userName")userName : String):Flowable<ArrayList<PersonData>>

    @GET("users/{userName}/following")
    fun getUserFollowingList(@Path("userName")userName : String):Flowable<ArrayList<PersonData>>
}