package com.capstone.jobamate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.jobamate.databinding.ActivityResumeUploadBinding

class ResumeUploadActivity : AppCompatActivity() {

    private var _binding: ActivityResumeUploadBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityResumeUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}