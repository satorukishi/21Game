package com.example.logonrm.a21game

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.logonrm.a21game.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentFragment: Fragment = GameFragment()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_jogar -> {
                if (currentFragment !is GameFragment) {
                    currentFragment = GameFragment()
                    changeFragment(currentFragment)
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sobre -> {
                if (currentFragment !is SobreFragment) {
                    currentFragment = SobreFragment()
                    changeFragment(currentFragment)
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sair -> {
                finish()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame, fragment)
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragment(currentFragment)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
