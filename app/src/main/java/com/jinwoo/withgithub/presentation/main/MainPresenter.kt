package com.jinwoo.withgithub.presentation.main

import com.jinwoo.withgithub.domain.usecase.GetUserFollowerListUseCase
import com.jinwoo.withgithub.domain.usecase.GetUserFollowingListUseCase
import com.jinwoo.withgithub.domain.usecase.GetUserProfileUseCase
import com.jinwoo.withgithub.domain.usecase.GetUserRepoListUseCase
import com.jinwoo.withgithub.presentation.base.BasePresenter
import com.jinwoo.withgithub.presentation.mapper.PersonMapper
import com.jinwoo.withgithub.presentation.mapper.ProfileMapper
import com.jinwoo.withgithub.presentation.mapper.RepoMapper
import io.reactivex.disposables.CompositeDisposable

class MainPresenter(
    val userRepoListCase: GetUserRepoListUseCase,
    val userFollowerListUseCase: GetUserFollowerListUseCase,
    val userFollowingListUseCase: GetUserFollowingListUseCase,
    val userProfileUseCase: GetUserProfileUseCase,
    val repoMapper: RepoMapper,
    val personMapper: PersonMapper,
    val profileMapper: ProfileMapper,
    composite: CompositeDisposable)
    : BasePresenter<MainContract.View>(composite), MainContract.Presenter {
    override fun createView(view: MainContract.View) {
        super.createView(view)

        view.setProfileData("", "", "", "", "", "")

        view.setRepoListAdapter(ArrayList())
        view.setFollowerListAdapter(ArrayList())
        view.setFollowingListAdapter(ArrayList())
    }

    override fun getRepoList(userName: String) {
        add(userRepoListCase.getUserRepoList(userName).subscribe({
            view.setRepoListAdapter(ArrayList(it.map { repoMapper.mapFrom(it) }))
        }, {
            view.createToast("조회 실패")
        }))
    }

    override fun getFollowerList(userName: String) {
        add(userFollowerListUseCase.getUserFollowerList(userName).subscribe({
            view.setFollowerListAdapter(ArrayList(it.map { personMapper.mapFrom(it) }))
        }, {
            view.createToast("조회 실패")
        }))
    }

    override fun getFollowingList(userName: String) {
        add(userFollowingListUseCase.getUserFollowingList(userName).subscribe({
            view.setFollowingListAdapter(ArrayList(it.map { personMapper.mapFrom(it) }))
        }, {
            view.createToast("조회 실패")
        }))
    }

    override fun getProfile(userName: String) {
        add(userProfileUseCase.getUserProfile(userName).subscribe({
            view.setProfileData(
                name = it.name,
                company = it.company,
                blog = it.blog,
                bio = it.bio,
                followers = it.followers,
                following = it.following
            )
        }, {
            view.createToast("조회 실패")
        }))
    }
}