package com.jetpack.lean.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jetpack.lean.R

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
        val loginTo = view.findViewById<TextView>(R.id.wel_button_login)
        val register = view.findViewById<TextView>(R.id.wel_button_register)
        loginTo.setOnClickListener {
            findNavController().navigate(R.id.welcome_to_login, null)
        }

        register.setOnClickListener {
            findNavController().navigate(R.id.welcome_to_register, null)
        }

    }

}