package com.jinwoo.withgithub.data.remote

import com.jinwoo.withgithub.data.entity.AuthData
import com.jinwoo.withgithub.data.entity.TokenData
import com.jinwoo.withgithub.data.remote.client.AuthApiClient
import io.reactivex.Flowable

class AuthRemote(val authApiClient: AuthApiClient) {

   fun getAccessToken(authData: AuthData): Flowable<TokenData> {
       return authApiClient.getAccessToken(hashMapOf(
           "client_id" to authData.clientId,
           "client_secret" to authData.clientSecret,
           "code" to authData.code))
   }
}