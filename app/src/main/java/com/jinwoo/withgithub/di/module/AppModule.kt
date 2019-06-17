package com.jinwoo.withgithub.di.module

import android.app.Application
import android.content.Context
import com.jinwoo.withgithub.di.app.BaseApp
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: BaseApp): Context = application

    @Provides
    @Singleton
    fun provideApplication(app: BaseApp): Application = app

    @Provides
    @Singleton
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}