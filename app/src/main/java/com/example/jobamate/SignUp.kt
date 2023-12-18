package com.example.jobamate

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jobamate.databinding.ActivitySignUpBinding
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        linkSetup()


        //button intent
        binding.btnDaftar.setOnClickListener{
            val intent = Intent(this, SignUpRecommendation::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener{
            val intent = Intent(this, LandingPage::class.java)
            startActivity(intent)
        }

        //item dropdown
        val items = listOf("  Pria", "  Wanita")

        val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_complete)

        val adapter = ArrayAdapter(this, R.layout.list_item_dropdown, items)

        autoComplete.setAdapter(adapter)

        //buat nampilin item dropodown, buat jaga" kalo error
//        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
//            adapterView, view, i, l ->
//
//            val itemSelected = adapterView.getItemAtPosition(i)
//            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
//        }

        binding.autoComplete.setAdapter(adapter)





    }


    //linktext
    private fun linkSetup(){
        val textMasukDisini = Link("Masuk disini!")
            .setTextColor(Color.BLUE)
            .setTextColorOfHighlightedLink(Color.CYAN)
            .setHighlightAlpha(.4f)
            .setUnderlined(true)
            .setBold(false)
            .setOnClickListener {
                startActivity(Intent(this, Login::class.java))
            }
        val bindingLink = binding.textMasukDisini
        bindingLink.applyLinks(textMasukDisini)

    }





}