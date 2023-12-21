package com.example.jobamate

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jobamate.api.UserApi
import com.example.jobamate.databinding.ActivitySignUpBinding
import com.example.jobamate.model.UserRequest
import com.example.jobamate.model.UserResponse
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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


        binding.autoComplete.setAdapter(adapter)

        register()



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


    fun register() {
        val request =  UserRequest()
        request.name = binding.inputnama.text.toString().trim()
        request.email = binding.inputemail.text.toString().trim()
        request.alamat = binding.inputalamat.text.toString().trim()
        request.tanggalLahir = binding.inputtanggallahir.text.toString().trim()
        request.gender = binding.inputjeniskelamin.toString().trim()
        request.password = binding.inputkatasandi.toString().trim()

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.register(request).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val user =  response.body()
                Log.e("msg", user!!.msg ?: "")
                println("berhasil")
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Error", t.message ?: "daftar akun gagal")
                println("daftar akun gagal")
            }

        })



        }



}