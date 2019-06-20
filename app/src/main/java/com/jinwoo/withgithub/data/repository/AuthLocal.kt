package com.jinwoo.withgithub.data.repository

import android.util.Log
import com.jinwoo.withgithub.data.datasource.AuthDataSource
import com.jinwoo.withgithub.data.entity.AuthData
import com.jinwoo.withgithub.data.entity.TokenData
import com.jinwoo.withgithub.data.local.LocalStorage
import io.reactivex.Single

class AuthLocal(val localStorage: LocalStorage){
    fun saveToken(token: String) = localStorage.saveToken(token)

    fun getToken(): String? {
        Log.d("localStorage.getToken()", localStorage.getToken())
        return localStorage.getToken()
    }
}