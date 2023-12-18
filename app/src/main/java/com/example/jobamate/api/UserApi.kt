package com.example.jobamate.api

import com.example.jobamate.model.UserRequest
import com.example.jobamate.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("login")
    fun login(@Body userRequest: UserRequest): retrofit2.Call<UserResponse>


}