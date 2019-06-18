package com.jinwoo.withgithub.presentation.base

import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BasePresenter<T: BaseContract.View>(val composite: CompositeDisposable): BaseContract.Presenter<T>{
    var weakReference: WeakReference<T>? =  null

    val view: T
        get() = weakReference?.get()!!

    override fun createView(view: T) {
        weakReference = WeakReference(view)
        view.setPresenter(this)
    }

    override fun destroyView() {
        weakReference?.clear()
        composite.clear()
    }
}