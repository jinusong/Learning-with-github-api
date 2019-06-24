package com.jinwoo.withgithub.presentation.signin

import android.util.Log
import com.jinwoo.withgithub.domain.usecase.AuthUseCase
import com.jinwoo.withgithub.presentation.base.BasePresenter
import com.jinwoo.withgithub.presentation.entity.Auth
import com.jinwoo.withgithub.presentation.mapper.AuthMapper
import io.reactivex.disposables.CompositeDisposable
import okhttp3.HttpUrl

class SignInPresenter(
    val authUseCase: AuthUseCase, val authMapper: AuthMapper, composite: CompositeDisposable):
    SignInContract.Presenter, BasePresenter<SignInContract.View>(composite) {
    override fun createView(view: SignInContract.View) {
        super.createView(view)
    }

    override fun signIn(id: String, secret: String, code: String) {
        if (!code.isBlank()) {
            add(authUseCase.getAuth(authMapper.mapFrom(Auth(id, secret, code))).subscribe({
                Log.d("dsfsdfdsfds",it.accessToken)
                view.createToast("로그인 성공!")
                view.launchMain()
            }, {
                view.createToast("로그인 실패 ㅠ")
            }))
        } else {
            view.createToast("웹과 연결되지 않았습니다!!")
        }
    }

    override fun loadWebView(id: String) {
        val httpUrl = HttpUrl.Builder()
            .scheme("https")
            .host("github.com")
            .addPathSegment("login")
            .addPathSegment("oauth")
            .addPathSegment("authorize")
            .addQueryParameter("client_id", id)
            .build()

        view.createWebView(httpUrl)
    }
}