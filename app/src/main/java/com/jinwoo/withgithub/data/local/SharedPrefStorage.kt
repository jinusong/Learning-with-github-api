package com.jinwoo.withgithub.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPrefStorage(val context: Context): LocalStorage {

    companion object {
        val authKey = "AuthToken"
    }

    override fun saveToken(token: String) =
        getPref(context).edit().let {
            it.putString(authKey, token)
            it.apply()
        }

    override fun getToken(): String? = getPref(context).getString(authKey, "")

    override fun removeToken() =
        getPref(context).edit().let {
            it.remove(authKey)
            it.apply()
        }

    private fun getPref(context: Context): SharedPreferences
            = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
}