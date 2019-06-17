package com.jinwoo.withgithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jinwoo.withgithub.R
import com.jinwoo.withgithub.presentation.MainPresenter
import com.jinwoo.withgithub.ui.base.BaseActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setPresenter(mainPresenter)
    }
}
