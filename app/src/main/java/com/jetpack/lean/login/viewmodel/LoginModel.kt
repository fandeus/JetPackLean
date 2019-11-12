package com.jetpack.lean.login.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.jetpack.lean.AppConstant
import com.jetpack.lean.R
import com.jetpack.lean.login.LoginFragment

/**
 * @author VenRen
 *
 * @time 2019-11-12  22:23
 *
 * @desc
 *
 */
class LoginModel constructor(name: String, pwd: String, context: Context, fragment: LoginFragment) {

    val userName = ObservableField<String>(name)
    val password = ObservableField<String>(pwd)
    var contextHolder = context
    val modelFragment = fragment;

    fun onNameChange(s: CharSequence) {
        userName.set(s.toString())
    }

    fun onPassword(s: CharSequence, start: Int, before: Int, count: Int) {
        password.set(s.toString())
    }

    fun login() {
        if (userName.get().equals(AppConstant.USER_NAME) && password.get().equals(AppConstant.PASSWORD)) {
            Toast.makeText(contextHolder, "密码正确", Toast.LENGTH_SHORT).show()
            findNavController(modelFragment).navigate(R.id.login_to_home)
        }
    }
}