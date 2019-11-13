package com.jetpack.lean

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    /**
     * 静态常量 和 方法
     */
    companion object {
        private lateinit var app: App

        fun getAppContext(): App {
            return app
        }
    }
}