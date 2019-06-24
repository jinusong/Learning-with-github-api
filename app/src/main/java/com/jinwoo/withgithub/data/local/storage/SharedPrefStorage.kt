package com.jinwoo.withgithub.data.local.storage

import android.content.Context
import android.content.SharedPreferences

class SharedPrefStorage(val context: Context): LocalStorage {

    override fun saveToken(token: String) =
        getPref(context).edit().let {
            it.putString("Access", token)
            it.apply()
        }

    override fun getToken(): String? = getPref(context).getString("Access", "")

    override fun removeToken() =
        getPref(context).edit().let {
            it.remove("Access")
            it.apply()
        }

    private fun getPref(context: Context): SharedPreferences
            = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
}