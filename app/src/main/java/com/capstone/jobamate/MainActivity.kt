package com.capstone.jobamate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import com.capstone.jobamate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // This is the main activity of the app
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeFragment -> {
                    replaceFragment(HomeFragment())
                    menuItem.setIcon(R.drawable.icons8_home)

                }
                R.id.jobaseekerFragment -> {
                    replaceFragment(JobaseekerFragment())
                    menuItem.setIcon(R.drawable.icon_jobaseeker)
                }
                R.id.bookmarkFragment -> {
                    replaceFragment(FavoriteFragment())
                    menuItem.setIcon(R.drawable.icon_favorite)
                    //binding.bottomNavView.itemTextColor = getColorStateList(R.color.primary)
                }
                R.id.profileFragment -> {
                    replaceFragment(ProfileFragment())
                    menuItem.setIcon(R.drawable.icon_profile)
                    //bottomNavView.itemTextColor = getColorStateList(R.color.primary)
                }
                else -> {
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmnentTransaction = fragmentManager.beginTransaction()
        fragmnentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmnentTransaction.commit()
    }
}