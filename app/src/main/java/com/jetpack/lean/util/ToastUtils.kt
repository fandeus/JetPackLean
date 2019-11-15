package com.jetpack.lean.util

import android.widget.Toast
import com.jetpack.lean.App

class ToastUtils {
    companion object {
        fun show(message: String) {
            Toast.makeText(App.getAppContext(), message, Toast.LENGTH_SHORT).show()
        }
    }
}