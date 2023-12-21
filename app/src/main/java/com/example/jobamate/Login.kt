package com.example.jobamate

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.jobamate.api.UserApi
import com.example.jobamate.databinding.ActivityLoginBinding
import com.example.jobamate.model.UserRequest
import com.example.jobamate.model.UserResponse
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        linkSetup()

        binding.btnBack.setOnClickListener{
            val intent = Intent(this, LandingPage::class.java)
            startActivity(intent)
        }

        initAction()
    }

    private fun linkSetup(){
        val textDaftarDisini = Link("Daftar disini!")
            .setTextColor(Color.BLUE)
            .setTextColorOfHighlightedLink(Color.CYAN)
            .setHighlightAlpha(.4f)
            .setUnderlined(true)
            .setBold(false)
            .setOnClickListener {
                startActivity(Intent(this, SignUp::class.java))
            }
        val bindingLink = binding.textDaftarDisini
        bindingLink.applyLinks(textDaftarDisini)

    }

    fun initAction() {
        binding.btnLoginn.setOnClickListener{
            login()
        }
    }

    fun login() {
        val request = UserRequest()
        request.email = binding.inputemail.text.toString().trim()
        request.password = binding.inputsandi.toString().trim()

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.login(request).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val user =  response.body()
                Log.e("msg", user!!.msg ?: "")
                println("berhasil")
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Error", t.message ?: "masuk gagal")
                println("masuk gagal")
            }
        })
    }

}