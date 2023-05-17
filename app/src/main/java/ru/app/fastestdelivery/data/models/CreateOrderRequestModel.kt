package ru.app.fastestdelivery.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateOrderRequestModel(
        val customerId: Int,
        val price: Double,
        val status: String
)