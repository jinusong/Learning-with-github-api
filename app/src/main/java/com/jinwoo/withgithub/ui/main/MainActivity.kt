package com.jinwoo.withgithub.ui.main

import android.os.Bundle
import com.jinwoo.withgithub.R
import com.jinwoo.withgithub.presentation.main.MainContract
import com.jinwoo.withgithub.presentation.main.MainPresenter
import com.jinwoo.withgithub.ui.base.BaseActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.createView(this)
    }
}
