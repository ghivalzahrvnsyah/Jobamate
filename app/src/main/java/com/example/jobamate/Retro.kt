package com.example.jobamate

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {
    fun getRetroClientInstance() : Retrofit {

        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("https://backend-dot-myproject123-408312.uc.r.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

}