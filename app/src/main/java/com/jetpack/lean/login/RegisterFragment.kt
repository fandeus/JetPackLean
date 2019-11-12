package com.jetpack.lean.login

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jetpack.lean.R


class RegisterFragment : Fragment() {

    val args: RegisterFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val back = view.findViewById<ImageView>(R.id.regiser_imageView)
        back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val email = view.findViewById<EditText>(R.id.register_editTextTextEmailAddress)
        email.text = Editable.Factory.getInstance().newEditable(args.email)
    }

}