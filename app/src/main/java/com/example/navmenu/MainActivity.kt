package com.example.navmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.navmenu.fragments.HomeFragment
import com.example.navmenu.fragments.favFragment
import com.example.navmenu.fragments.GameFragment
import com.example.navmenu.fragments.HeadSetFramgent
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeFramgent = HomeFragment()
        val FavFragment = favFragment()
        val gamefragment = GameFragment()
        val headSetframgent = HeadSetFramgent()
        navigation = findViewById(R.id.bottom_navigation)
        makeCurrentFragment(homeFramgent)

        navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFramgent)
                R.id.ic_favorite -> makeCurrentFragment(FavFragment)
                R.id.ic_game -> makeCurrentFragment(gamefragment)
                R.id.ic_headset -> makeCurrentFragment(headSetframgent)
            }
            true
        }


    }
    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
    }
}