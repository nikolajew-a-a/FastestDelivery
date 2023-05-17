package ru.app.fastestdelivery.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequestModel(
    val name: String = "vasan",
    val email: String,
    val password: String
)