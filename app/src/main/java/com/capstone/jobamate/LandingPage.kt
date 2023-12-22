package com.capstone.jobamate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.capstone.jobamate.databinding.ActivityLandingPageBinding

class  LandingPage : AppCompatActivity() {

    private var textTitle= mutableListOf<String>()
    private var textDescription= mutableListOf<String>()
    private var itemImage= mutableListOf<Int>()
    private lateinit var binding: ActivityLandingPageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // untuk hide toolbar dan action bar
        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        //supportActionBar?.hide()
        //This is landing page


        // input data view pager di landing page
        addToList( "Selamat Datang di Jobamate", "Tingkatkan karir Anda bersama kami", R.drawable.itemlandingpage1)
        addToList("Jelajahi Peluang", "Berkolaborasi dengan lebih dari 50+ perusahaan, berdedikasi untuk mempekerjakan penyandang disabilitas", R.drawable.itemlandingpage2)
        addToList("Tingkatkan Keterampilan Anda", "Menghadiri pelatihan gratis dengan para ahli", R.drawable.itemlandingpage3)


        binding.viewPagerOnboarding.apply {
            adapter = LandingPageAdapter(textTitle, textDescription, itemImage)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        binding.indicator.setViewPager(binding.viewPagerOnboarding)



        // button
        binding.btnLogin.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    private fun addToList(title : String,description : String,image:Int){
        textTitle.add(title)
        textDescription.add(description)
        itemImage.add(image)
    }

}