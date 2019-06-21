package com.jinwoo.withgithub.presentation.signin

import com.jinwoo.withgithub.domain.usecase.GetAuthUseCase
import com.jinwoo.withgithub.presentation.base.BasePresenter
import com.jinwoo.withgithub.presentation.entity.Auth
import com.jinwoo.withgithub.presentation.mapper.AuthMapper
import io.reactivex.disposables.CompositeDisposable
import okhttp3.HttpUrl

class SignInPresenter(
    val authUseCase: GetAuthUseCase, val authMapper: AuthMapper, composite: CompositeDisposable):
    SignInContract.Presenter, BasePresenter<SignInContract.View>(composite) {
    override fun createView(view: SignInContract.View) {
        super.createView(view)
    }

    override fun signIn(id: String, secret: String, code: String) {
        if (!code.isBlank()) {
            add(authUseCase.getAuth(authMapper.mapFrom(Auth(id, secret, code))).subscribe({
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