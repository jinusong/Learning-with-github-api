package com.jinwoo.withgithub.presentation.ui.main

import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.jinwoo.withgithub.R
import com.jinwoo.withgithub.presentation.adapter.FollowerListAdapter
import com.jinwoo.withgithub.presentation.adapter.FollowingListAdapter
import com.jinwoo.withgithub.presentation.adapter.RepoListAdapter
import com.jinwoo.withgithub.presentation.entity.Person
import com.jinwoo.withgithub.presentation.entity.Repo
import com.jinwoo.withgithub.presentation.main.MainContract
import com.jinwoo.withgithub.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.createView(this)

        main_toolbar_search.onClick { searchUser(main_toolbar_edit.text.toString()) }
    }

    fun searchUser(userName: String) {
        presenter.getProfile(userName)
        presenter.getRepoList(userName)
        presenter.getFollowerList(userName)
        presenter.getFollowingList(userName)
    }

    override fun setProfileData(
        name: String,
        company: String,
        blog: String,
        bio: String,
        followers: String,
        following: String
    ) {
        main_user_name.text = "name: $name"
        main_user_company.text = "company: $company"
        main_user_blog.text = "blog: $blog"
        main_user_bio.text = "bio: $bio"
        main_user_followers.text = "followers: $followers"
        main_user_following.text = "following: $following"
    }

    override fun setRepoListAdapter(models: ArrayList<Repo>){
        main_repo_list.layoutManager = LinearLayoutManager(this)
        main_repo_list.adapter = RepoListAdapter(models)
    }

    override fun setFollowerListAdapter(models: ArrayList<Person>) {
        main_follower_list.layoutManager = LinearLayoutManager(this)
        main_follower_list.adapter = FollowerListAdapter(models)
    }

    override fun setFollowingListAdapter(models: ArrayList<Person>) {
        main_following_list.layoutManager = LinearLayoutManager(this)
        main_following_list.adapter = FollowingListAdapter(models)
    }

    override fun createToast(text: String) { toast(text) }

}
