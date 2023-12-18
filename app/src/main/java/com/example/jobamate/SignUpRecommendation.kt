package com.example.jobamate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jobamate.databinding.ActivitySignUpRecommendationBinding

class SignUpRecommendation : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpRecommendationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpRecommendationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }



    }
}