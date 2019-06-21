package com.jinwoo.withgithub.di.module

import com.jinwoo.withgithub.di.module.main.MainModule
import com.jinwoo.withgithub.di.module.signin.SignInModule
import com.jinwoo.withgithub.di.scope.ActivityScope
import com.jinwoo.withgithub.ui.main.MainActivity
import com.jinwoo.withgithub.ui.signin.SignInActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun activityMain(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SignInModule::class])
    abstract fun activitySignIn(): SignInActivity
}