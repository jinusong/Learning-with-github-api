package com.jinwoo.withgithub.presentation.main

import com.jinwoo.withgithub.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable

class MainPresenter(composite: CompositeDisposable): BasePresenter<MainContract.View>(composite) {
    override fun createView(view: MainContract.View) {
        super.createView(view)
    }
}