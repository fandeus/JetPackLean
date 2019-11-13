package com.jetpack.lean.login.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
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

    val n = ObservableField<String>(name)
    val p = ObservableField<String>(pwd)
    var _context: Context = context
    var _fragment: Fragment = fragment


    /**
     * 用户名改变的回调
     */
    fun onNameChanged(sequence: CharSequence) {
        n.set(sequence.toString())
    }

    /**
     * 密码改变时的回调
     */
    fun onPwdChange(sequence: CharSequence) {
        p.set(sequence.toString())
    }

    fun userLogin() {
        if (n.get().equals(AppConstant.USER_NAME) &&
            p.get().equals(AppConstant.PASSWORD)
        ) {
            Toast.makeText(_context, "密码正确", Toast.LENGTH_SHORT).show()
            findNavController(_fragment).navigate(R.id.login_to_home)
        } else {
            Toast.makeText(_context, "密码错误", Toast.LENGTH_SHORT).show()
        }

    }

}