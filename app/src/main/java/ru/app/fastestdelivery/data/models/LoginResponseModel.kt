package ru.app.fastestdelivery.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LoginResponseModel(
    @Json(name = "email") val bla: String,
    val password: String,
)