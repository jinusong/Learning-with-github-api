package com.jinwoo.withgithub.presentation.main

import com.jinwoo.withgithub.presentation.entity.Person
import com.jinwoo.withgithub.presentation.entity.Repo
import com.jinwoo.withgithub.presentation.base.BaseContract

interface MainContract{
    interface View: BaseContract.View {
        fun setProfileData(name: String, company: String, blog: String,
                           bio: String, followers: String, following: String)
        fun setRepoListAdapter(models: ArrayList<Repo>)
        fun setFollowerListAdapter(models: ArrayList<Person>)
        fun setFollowingListAdapter(models: ArrayList<Person>)

        fun createToast(text: String)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getProfile(userName: String)
        fun getRepoList(userName:String)
        fun getFollowerList(userName: String)
        fun getFollowingList(userName: String)
    }
}