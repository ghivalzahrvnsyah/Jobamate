package com.capstone.jobamate.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Job (
    val id: Long,
    val title: String,
    val companyName: String,
    val location: String,
    val salary: String,
    val description: String,
    val responsibility: String,
    val qualification: String
): Parcelable