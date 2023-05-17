package ru.app.fastestdelivery.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LoginResponseModel(
    val name: String,
    val userId: Int,
    val token: String
)