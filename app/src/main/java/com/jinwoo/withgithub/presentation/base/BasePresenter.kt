package com.jinwoo.withgithub.presentation.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter(val composite: CompositeDisposable) : BaseContract.Presenter{
    override fun destroyView() = composite.clear()
}