package ru.app.fastestdelivery.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetAllProductsResponseModel(
        val products: List<ProductResponseModel>,
        val numberOfRows: Int

)

@JsonClass(generateAdapter = true)
data class ProductResponseModel(
        val id: Int,
        val name: String,
        val quantity: Int,
        var price: Int?,
        var description: String?,
        var type: String?,
        var energyValue: Int?,
        var weight: Int?,
        var photos: List<PhotosResponseModel>
)

@JsonClass(generateAdapter = true)
data class PhotosResponseModel(
        @Json(name = "photo_name")
        val photoName: String,
        val photo: String
)

