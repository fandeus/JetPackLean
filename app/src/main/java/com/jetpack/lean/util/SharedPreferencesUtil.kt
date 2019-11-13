package com.jetpack.lean.util

import android.content.Context
import android.content.SharedPreferences
import com.jetpack.lean.App
import com.jetpack.lean.R

class SharedPreferencesUtil {

    companion object {

        fun setData(dataKey: String, dataValue: String) {
            getSharedPreferences().edit().putString(dataKey, dataValue).apply()
        }

        fun setData(dataKey: String, dataValue: Int) {
            getSharedPreferences().edit().putInt(dataKey, dataValue).apply()
        }


        fun setData(dataKey: String, dataValue: Float) {
            getSharedPreferences().edit().putFloat(dataKey, dataValue).apply()
        }

        fun setData(dataKey: String, dataValue: Boolean) {
            getSharedPreferences().edit().putBoolean(dataKey, dataValue).apply()
        }


        fun getString(dataKey: String): String? {
            return getSharedPreferences().getString(dataKey, "")
        }

        fun getInt(dataKey: String): Int? {
            return getSharedPreferences().getInt(dataKey, 0)
        }

        fun getBoolean(dataKey: String): Boolean {
            return getSharedPreferences().getBoolean(dataKey, false)
        }

        fun getFloat(dataKey: String): Float {
            return getSharedPreferences().getFloat(dataKey, 0f)
        }



        private fun getSharedPreferences(): SharedPreferences {
            return App.getAppContext()
                .getSharedPreferences(
                    App.getAppContext().resources.getString(R.string.app_name),
                    Context.MODE_PRIVATE
                )
        }
    }

}