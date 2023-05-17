package ru.app.fastestdelivery.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateOrderResponseModel(
        val message: String
)