package com.example.jobamate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.jobamate.databinding.ActivityLandingPageBinding


class  LandingPage : AppCompatActivity() {

    private var textTitle= mutableListOf<String>()
    private var textDescription= mutableListOf<String>()
    private var itemImage= mutableListOf<Int>()
    private lateinit var binding: ActivityLandingPageBinding




//    private val landingPageAdapter = LandingPageAdapter(
//        listOf(
//            LandingPageModel(
//                "konten1",
//                "Let's prepare your glorious career\n" +
//                        "With us...",
//                R.drawable.itemlandingpage1
//            ),
//             LandingPageModel(
//                "konten1",
//                "Let's prepare your glorious career\n" +
//                        "With us...",
//                R.drawable.itemlandingpage1
//            ),
//            LandingPageModel(
//                "konten1",
//                "Let's prepare your glorious career\n" +
//                        "With us...",
//                R.drawable.itemlandingpage1
//            )
//        )
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        //supportActionBar?.hide()

        addToList( "Welcome to Jobamate", "Improve your career with us", R.drawable.itemlandingpage1)
        addToList("Explore Opportunities", "Collaborating with over 50+ companies, dedicated to employing individuals with disabilities.", R.drawable.itemlandingpage2)
        addToList("Improve Your Skill", "Attending free training sessions with experts", R.drawable.itemlandingpage3)


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
    }

    private fun addToList(title : String,description : String,image:Int){
        textTitle.add(title)
        textDescription.add(description)
        itemImage.add(image)

        //cek
    }

}