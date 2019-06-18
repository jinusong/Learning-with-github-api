package com.jinwoo.withgithub.presentation.signin

import com.jinwoo.withgithub.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable

class SignInPresenter(composite: CompositeDisposable): SignInContract.Presenter, BasePresenter<SignInContract.View>(composite) {
    override fun createView(view: SignInContract.View) {
        super.createView(view)

    }
}