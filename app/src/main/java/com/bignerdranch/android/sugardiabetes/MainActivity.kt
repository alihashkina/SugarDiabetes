package com.bignerdranch.android.sugardiabetes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var menu: BottomNavigationView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu = findViewById(R.id.menu)
        menu.setOnNavigationItemSelectedListener {
                item ->
            when (item.itemId) {
                R.id.generalPage -> {
                   // supportFragmentManager.beginTransaction().replace(R.id.containerView, ListOfApplicationsAll.newInstance()).addToBackStack(null).commit()
                }
                R.id.calendar -> {
                   // supportFragmentManager.beginTransaction().replace(R.id.containerView, ListEquipment.newInstance()).addToBackStack(null).commit()
                }
                R.id.statistic -> {
                   // supportFragmentManager.beginTransaction().replace(R.id.containerView, GeneralPage.newInstance()).addToBackStack(null).commit()
                }
                R.id.setting -> {
                    // supportFragmentManager.beginTransaction().replace(R.id.containerView, GeneralPage.newInstance()).addToBackStack(null).commit()
                }

            }
            true
        }


        if (savedInstanceState == null) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            supportFragmentManager.beginTransaction()
                .add(R.id.containerView, GeneralPage.newInstance())
                .addToBackStack(null)
                .commit()
        }

    }


}