package com.jinwoo.withgithub.data.repository

import android.util.Log
import com.jinwoo.withgithub.data.entity.AuthData
import com.jinwoo.withgithub.data.entity.TokenData
import com.jinwoo.withgithub.data.remote.client.AuthApiClient
import io.reactivex.Flowable
import io.reactivex.Single

class AuthRemote(val authApiClient: AuthApiClient) {

   fun getAccessToken(authData: AuthData): Flowable<TokenData> {
       return authApiClient.getAccessToken(hashMapOf(
           "client_id" to authData.clientId,
           "client_secret" to authData.clientSecret,
           "code" to authData.code))
   }
}