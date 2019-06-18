package com.jinwoo.withgithub.di.module

import com.jinwoo.withgithub.data.remote.api.Api
import com.jinwoo.withgithub.data.remote.api.AuthApi
import com.jinwoo.withgithub.data.remote.client.ApiClient
import com.jinwoo.withgithub.data.remote.client.AuthApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideAuthClient(githubTokenApi: AuthApi) = AuthApiClient(githubTokenApi)

    @Provides
    @Singleton
    fun provideApiClient(githubApi: Api) = ApiClient(githubApi)
}