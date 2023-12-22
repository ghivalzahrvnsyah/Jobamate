package com.capstone.jobamate.api

import com.capstone.jobamate.model.UserRequest
import com.capstone.jobamate.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("login")
    fun login(@Body userRequest: UserRequest): retrofit2.Call<UserResponse>

    @POST("register")
    fun register(@Body userRequest: UserRequest): retrofit2.Call<UserResponse>




}