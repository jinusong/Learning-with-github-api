package com.jinwoo.withgithub.di.module.signin

import com.jinwoo.withgithub.di.scope.ActivityScope
import com.jinwoo.withgithub.presentation.signin.SignInPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class SignInModule {
    @ActivityScope
    @Provides
    fun provideSignInPresenter(composite: CompositeDisposable) = SignInPresenter(composite)
}