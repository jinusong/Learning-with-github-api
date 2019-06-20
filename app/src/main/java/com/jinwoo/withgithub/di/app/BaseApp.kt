package com.jinwoo.withgithub.di.app

import com.jinwoo.withgithub.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
            = DaggerAppComponent.builder().application(this).build()
}