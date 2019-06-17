package com.jinwoo.withgithub.di.module

import com.jinwoo.withgithub.di.module.main.MainModule
import com.jinwoo.withgithub.di.scope.ActivityScope
import com.jinwoo.withgithub.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun activityMain(): MainActivity
}