package com.jinwoo.withgithub.di.module.main

import com.jinwoo.withgithub.di.scope.ActivityScope
import com.jinwoo.withgithub.presentation.MainPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MainModule {
    @ActivityScope
    @Provides
    fun provideMainPresenter(composite: CompositeDisposable) = MainPresenter(composite)
}