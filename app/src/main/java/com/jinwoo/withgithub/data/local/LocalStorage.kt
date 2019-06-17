package com.jinwoo.withgithub.data.local

interface LocalStorage {

    fun saveToken(token: String)

    fun getToken(): String?

    fun removeToken()
}