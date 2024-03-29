package com.jinwoo.withgithub.presentation.ui.signin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.jinwoo.withgithub.BuildConfig
import com.jinwoo.withgithub.R
import com.jinwoo.withgithub.presentation.signin.SignInContract
import com.jinwoo.withgithub.presentation.ui.base.BaseActivity
import com.jinwoo.withgithub.presentation.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_signin.*
import okhttp3.HttpUrl
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class SignInActivity: BaseActivity(), SignInContract.View {

    @Inject
    lateinit var presenter: SignInContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        presenter.createView(this)

        signin_login_btn.onClick {
            presenter.loadWebView(BuildConfig.GITHUB_CLIENT_ID)
        }
    }

    override fun onResume() {
        super.onResume()
        val code = intent.data?.getQueryParameter("code")

        code?.let {
            presenter.signIn(BuildConfig.GITHUB_CLIENT_ID, BuildConfig.GITHUB_CLIENT_SECRET, it)
        }
    }

    override fun createWebView(url: HttpUrl) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url.toString())).let {
            startActivity(it)
            startActivityForResult(it,100)
        }
    }

    override fun createToast(text: String) { toast(text) }

    override fun launchMain() = startActivity<MainActivity>()
}