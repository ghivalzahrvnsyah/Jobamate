package com.capstone.jobamate

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.capstone.jobamate.databinding.ActivityDetailJobBinding
import com.capstone.jobamate.databinding.FragmentJobaseekerBinding
import com.capstone.jobamate.model.Job

class DetailJobActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailJobBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnBack.setOnClickListener {
           onBackPressed()
        }

        val dataJob = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Job>("key_job", Job::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Job>("key_job")
        }

        if (dataJob != null) {
            binding.tvCompanyName.text = dataJob.companyName
            binding.tvLokasi.text = dataJob.location
            binding.tvJobSalary.text = dataJob.salary
            binding.tvJobDescription.text = dataJob.description
            binding.tvJobResponsibility.text = dataJob.responsibility
            binding.tvJobTermscondition.text = dataJob.qualification
            binding.ivBannercompany.setImageResource(dataJob.image)
        } else {
            val noDataFound = "Data tidak ditemukan"
            binding.tvCompanyName.text = noDataFound
            binding.tvLokasi.text = noDataFound
            binding.tvJobSalary.text = noDataFound
            binding.tvJobDescription.text = noDataFound
            binding.tvJobTermscondition.text = noDataFound
        }
    }

}
