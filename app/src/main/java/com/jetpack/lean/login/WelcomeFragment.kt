package com.jetpack.lean.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.jetpack.lean.R
import com.jetpack.lean.db.AppConstant
import com.jetpack.lean.util.SharedPreferencesUtil

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflater the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = view.findViewById<TextView>(R.id.wel_button_login)
        val register = view.findViewById<TextView>(R.id.wel_button_register)


        if (SharedPreferencesUtil.getBoolean(AppConstant.USER_LOGIN)) {
            //设置动画参数
            val navOption = navOptions {
                anim {
                    enter = R.anim.common_fade_in
                    exit = R.anim.common_fade_out
                    popEnter = R.anim.common_fade_in
                    popExit = R.anim.common_fade_out
                }
            }

            //参数设置
            val bundle = Bundle()
            bundle.putString("name", "TeaOf")
            findNavController().navigate(R.id.welcome_to_home, bundle, navOption)
            return
        }


        //启动方式一
        login.setOnClickListener {
            //设置动画参数
            val navOption = navOptions {
                anim {
                    enter = R.anim.common_slide_in_right
                    exit = R.anim.common_slide_out_left
                    popEnter = R.anim.common_slide_in_left
                    popExit = R.anim.common_slide_out_right
                }
            }
            //参数设置
            val bundle = Bundle()
            bundle.putString("name", "TeaOf")
            findNavController().navigate(R.id.welcome_to_login, bundle, navOption)
        }

        //启动方式二
        register.setOnClickListener {
            val action = WelcomeFragmentDirections
                .welcomeToRegister()
                .setEMAIL("TestEmail@gmail.com")
            findNavController().navigate(action)
        }

    }

}