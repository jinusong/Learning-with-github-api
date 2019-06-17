package com.jinwoo.withgithub.ui.base

import com.jinwoo.withgithub.presentation.base.BaseContract
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity(), BaseContract.View {

    private lateinit var presenter: BaseContract.Presenter<BaseContract.View>

    override fun setPresenter(presenter: BaseContract.Presenter<BaseContract.View>) {
        this.presenter = presenter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroyView()
    }
}