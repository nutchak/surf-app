package com.example.team35_surfeapp.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.team35_surfeapp.R
import com.example.team35_surfeapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //code from: https://developer.android.com/guide/navigation/navigation-ui#bottom_navigation
        //sets up the navController with the bottom navigation view
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setupWithNavController(navController)

        //https://developer.android.com/guide/navigation/navigation-ui#argument
        //makes sure you cant navigate while on the info page
        navController.addOnDestinationChangedListener { _, dest, _ ->
            binding.bottomNavigationView.isVisible =
                !(dest.displayName == "com.example.team35_surfeapp:id/infoPage" ||
                    dest.displayName == "com.example.team35_surfeapp:id/splashScreen" ||
                    dest.displayName == "com.example.team35_surfeapp:id/viewPagerFragment")
        }

    }

}