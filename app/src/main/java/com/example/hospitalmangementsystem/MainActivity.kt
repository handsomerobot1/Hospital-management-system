package com.example.hospitalmangementsystem

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        // Load HomePageFragment by default
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.nav_host_fragment, homepageFragment())
            }
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.commit {
                        replace(R.id.nav_host_fragment, homepageFragment())
                    }
                    true
                }
                R.id.nav_appointments -> {
                    supportFragmentManager.commit {
                        replace(R.id.nav_host_fragment, appointmentFragment())
                    }
                    true
                }
                R.id.nav_profile -> {
                    supportFragmentManager.commit {
                        replace(R.id.nav_host_fragment, profileFragment())
                    }
                    true
                }
                else -> false
            }
        }
    }
}
