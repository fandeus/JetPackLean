package com.jetpack.lean.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jetpack.lean.R

class MainFragment : Fragment() {

    private lateinit var currentFragment: Fragment

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

        currentFragment = Fragment()

        val homeFragment: Fragment = HomeFragment()
        val likeFragment: Fragment = LikeFragment()
        val mineFragment: Fragment = MineFragment()

        val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.main_home -> {
                    toolbar.title = "主页"
                    selectedFragment(homeFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.main_market -> {
                    toolbar.title = "收藏"
                    selectedFragment(likeFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.main_mine -> {
                    toolbar.title = "我的"
                    selectedFragment(mineFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        bottomNav.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        selectedFragment(homeFragment)
    }

    private fun selectedFragment(targetFragment: Fragment) {
        val fragmentManager: FragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (!targetFragment.isAdded) {
            fragmentTransaction.hide(currentFragment)
                .add(R.id.home_frame_layout, targetFragment, targetFragment.javaClass.name)
                .commit()
        } else {
            fragmentTransaction.hide(currentFragment)
                .show(targetFragment)
                .commit()
        }
        currentFragment = targetFragment
    }
}