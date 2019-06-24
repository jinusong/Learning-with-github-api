package com.jinwoo.withgithub.di.module

import android.content.Context
import com.jinwoo.withgithub.data.local.storage.LocalStorage
import com.jinwoo.withgithub.data.local.storage.SharedPrefStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {
    @Provides
    @Singleton
    fun  provideLocalStorage(context: Context): LocalStorage =
        SharedPrefStorage(context)
}