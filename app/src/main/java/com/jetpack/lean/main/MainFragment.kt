package com.jetpack.lean.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jetpack.lean.R

class MainFragment : Fragment() {


    private val fragmentList = mutableListOf<Fragment>()
    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: Toolbar = view.findViewById(R.id.main_toolbar)
        val bottomNav: BottomNavigationView = view.findViewById(R.id.bottomNavigationView)

        toolbar.title = "主页"

        fragmentList.add(HomeFragment())
        fragmentList.add(LikeFragment())
        fragmentList.add(MineFragment())

        val fragmentManager: FragmentManager = childFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()


        val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.main_home -> {
                    selectedPosition(0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.main_market -> {
                    selectedPosition(1)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.main_mine -> {
                    selectedPosition(2)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        bottomNav.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        selectedPosition(0)
    }

    private fun selectedPosition(position: Int) {
        fragmentTransaction.replace(R.id.home_frame_layout, fragmentList[position])
    }


}