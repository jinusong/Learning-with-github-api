package com.jinwoo.withgithub.presentation.base

interface BaseContract {
    interface Presenter<T> {
        fun createView(view: T)
        fun destroyView()
    }
    interface View {
        fun setPresenter(presenter: Presenter<View>)
    }
}