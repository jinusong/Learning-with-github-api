package com.jinwoo.withgithub.data.local.auth

import android.util.Log
import com.jinwoo.withgithub.data.local.storage.LocalStorage

class AuthLocal(val localStorage: LocalStorage){
    fun saveToken(token: String) = localStorage.saveToken(token)

    fun getToken(): String? {
        Log.d("localStorage.getToken()", localStorage.getToken())
        return localStorage.getToken()
    }
}