package com.capstone.jobamate.model

data class User (
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val phone: String,
    val image: Int
)