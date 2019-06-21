package com.jinwoo.withgithub.data.remote.client

import com.jinwoo.withgithub.data.entity.TokenData
import com.jinwoo.withgithub.data.remote.api.AuthApi
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class AuthApiClient(val authApi: AuthApi) {
    fun getAccessToken(body: Any?): Flowable<TokenData> =
        authApi.getAccessToken(body)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}