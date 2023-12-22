package com.capstone.jobamate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.capstone.jobamate.databinding.ActivitySignupRecomendationBinding

class SignUpRecommendation : AppCompatActivity() {

    private lateinit var binding: ActivitySignupRecomendationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignupRecomendationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        //item dropdown
        val item_disability = listOf("  Cacat Kaki",
            "  Cacat Tangan",
            "  Tuna Netra",
            "  Tuna Rungu",
            " Tuna Wicara")

        val item_location = listOf("  Bali",
            "  Banten",
            "  Jambi",
            "  Jawa Barat",
            "  Jawa Tengah",
            "  Jawa Timur",
            "  Kalimantan Barat",
            "  Kalimantan Selatan",
            "  Kalimantan Tengah",
            "  Kalimantan Timur",
            "  Lampung",
            "  Nusa Tenggara Barat",
            "  Nusa Tenggara Timur",
            "  Riau",
            "  Sulawesi Selatan",
            "  Sulawesi Tengah",
            "  Sulawesi Tenggara")

        val item_skill = listOf("  Administrasi",
            "  Buruh",
            "  Desain Grafis",
            "  Editor",
            "  IT",
            "  Kreatif",
            "  Manajemen",
            "  Marketing",
            "  Membersihkan Lingkungan Tertentu",
            "  Mengajar",
            "  Mengetik",
            "  Menguasai Bahasa",
            "  Menguasai Bahasa Isyarat",
            "  Musik",
            "  Olahraga",
            "  Pustakawan",
            "  Seni",
            "  Teks Braille",
            "  Menulis Kreatif",
            "  Psikologi",
            "  Tata Hidang",
            "  Teknik Sipil")

        val autoComplete_disability : AutoCompleteTextView = findViewById(R.id.auto_complete_disabilitas)
        val autoComplete_location : AutoCompleteTextView = findViewById(R.id.auto_complete_lokasi)
        val autoComplete_skill : AutoCompleteTextView = findViewById(R.id.auto_complete_keahlian)

        val adapter_disability = ArrayAdapter(this, R.layout.list_item_dropdown, item_disability)
        val adapter_location = ArrayAdapter(this, R.layout.list_item_dropdown, item_location)
        val adapter_skill = ArrayAdapter(this, R.layout.list_item_dropdown, item_skill)

        autoComplete_disability.setAdapter(adapter_disability)
        autoComplete_location.setAdapter(adapter_location)
        autoComplete_skill.setAdapter((adapter_skill))

        binding.btnDaftar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }
}