package com.jinwoo.withgithub.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jinwoo.withgithub.data.local.storage.LocalStorage
import com.jinwoo.withgithub.data.remote.interceptor.AuthInterceptor
import com.jinwoo.withgithub.data.remote.api.Api
import com.jinwoo.withgithub.data.remote.api.AuthApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule() {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthInterceptor(localStorage: LocalStorage): AuthInterceptor {
        val token = localStorage.getToken() ?: throw IllegalStateException("authToken cannot be null.")
        return AuthInterceptor(token)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideApi(gson: Gson, okHttpClient: OkHttpClient): Api {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthApi(gson: Gson, okHttpClient: OkHttpClient) : AuthApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://github.com/")
            .client(okHttpClient)
            .build()
            .create(AuthApi::class.java)
    }

}
