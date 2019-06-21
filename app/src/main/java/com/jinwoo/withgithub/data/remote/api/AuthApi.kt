package com.jinwoo.withgithub.data.remote.api

import com.jinwoo.withgithub.data.entity.TokenData
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {
    @POST("login/oauth/access_token")
    @Headers("Accept: application/json")
    fun getAccessToken(@Body body: Any?): Flowable<TokenData>
}