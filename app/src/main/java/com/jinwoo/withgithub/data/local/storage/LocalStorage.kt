package com.jinwoo.withgithub.data.local.storage

interface LocalStorage {

    fun saveToken(token: String)

    fun getToken(): String?

    fun removeToken()
}