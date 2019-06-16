package com.jinwoo.withgithub.presentation.base

interface BaseContract {
    interface Presenter {
        fun destroyView()
    }
    interface View {
        fun setPresenter(presenter: Presenter)
    }
}