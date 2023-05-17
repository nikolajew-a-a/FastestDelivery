package ru.app.fastestdelivery.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.app.fastestdelivery.data.models.CreateOrderRequestModel
import ru.app.fastestdelivery.data.models.CreateOrderResponseModel
import ru.app.fastestdelivery.data.models.GetAllProductsResponseModel
import ru.app.fastestdelivery.data.models.OrderResponseModel
import ru.app.fastestdelivery.data.models.LoginRequestModel
import ru.app.fastestdelivery.data.models.LoginResponseModel
import ru.app.fastestdelivery.data.models.RegisterRequestModel
import ru.app.fastestdelivery.data.models.RegisterResponseModel

interface AppApi {

    @POST("customers/login")
    suspend fun login(@Body params: LoginRequestModel): Response<LoginResponseModel>

    @POST("customers/register")
    suspend fun register(@Body params: RegisterRequestModel): Response<RegisterResponseModel>

    @GET("products/all")
    suspend fun allProducts(): Response<GetAllProductsResponseModel>

    @GET("orders/getOrders/{customer_id}")
    suspend fun getOrders(@Path(value = "customer_id", encoded = true) customerId: Int): Response<List<OrderResponseModel>>

    @POST("orders/create")
    suspend fun createOrder(@Body params: CreateOrderRequestModel): Response<CreateOrderResponseModel>

}