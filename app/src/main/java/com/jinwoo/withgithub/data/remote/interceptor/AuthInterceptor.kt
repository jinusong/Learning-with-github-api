package com.jinwoo.withgithub.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthInterceptor(private val token: String): Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        with(chain) {
            val newRequest = request().newBuilder().run {
                addHeader("Authorization", "token " + token)
                build()
            }
            return proceed(newRequest)
        }
    }
}