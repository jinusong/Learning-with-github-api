package com.jinwoo.withgithub.ui.signin

import android.os.Bundle
import com.jinwoo.withgithub.R
import com.jinwoo.withgithub.presentation.signin.SignInContract
import com.jinwoo.withgithub.presentation.signin.SignInPresenter
import com.jinwoo.withgithub.ui.base.BaseActivity
import javax.inject.Inject

class SignInActivity: BaseActivity(), SignInContract.View {

    @Inject
    lateinit var presenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        presenter.createView(this)

    }
}