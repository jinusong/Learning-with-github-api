package com.jinwoo.withgithub.presentation.signin

import com.jinwoo.withgithub.presentation.base.BaseContract
import okhttp3.HttpUrl

interface SignInContract {
    interface View: BaseContract.View {
        fun createToast(text: String)
        fun launchMain()
        fun createWebView(url: HttpUrl)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun signIn(id: String, secret: String, code: String)
        fun loadWebView(id: String)
    }
}