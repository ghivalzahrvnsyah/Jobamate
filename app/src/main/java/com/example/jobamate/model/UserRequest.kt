package com.example.jobamate.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("tanggal lahir")
    @Expose
    var tanggalLahir: String? = null

    @SerializedName("telepon")
    @Expose
    var telepon: String? = null

    @SerializedName("alamat")
    @Expose
    var alamat: String? = null

    @SerializedName("gender")
    @Expose
    var gender: String? = null


}