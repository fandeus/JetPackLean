package com.jetpack.lean.login

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jetpack.lean.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //第一种方式
        val nameStr = arguments?.getString("name")

        super.onViewCreated(view, savedInstanceState)
        val back = view.findViewById<ImageView>(R.id.login_back)
        back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val name = view.findViewById<EditText>(R.id.login_editTextTextPersonName)

        //设置一个可能为空的参数
        name.text = Editable.Factory.getInstance().newEditable(nameStr)

        val loginButton = view.findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            findNavController().navigate(R.id.login_to_home)
        }
    }

}