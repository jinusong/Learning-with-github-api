package com.jinwoo.withgithub.presentation.main

import com.jinwoo.withgithub.presentation.base.BaseContract

interface MainContract{
    interface View: BaseContract.View {
    }

    interface Presenter: BaseContract.Presenter<View> {

    }
}