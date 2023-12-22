package com.capstone.jobamate.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {

    @SerializedName("msg")
    @Expose
    var msg: String? = null

}