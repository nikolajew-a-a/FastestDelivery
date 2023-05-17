package ru.app.fastestdelivery.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.app.fastestdelivery.data.models.GetAllProductsResponseModel
import ru.app.fastestdelivery.data.models.LoginRequestModel
import ru.app.fastestdelivery.data.models.LoginResponseModel
import ru.app.fastestdelivery.data.models.RegisterRequestModel
import ru.app.fastestdelivery.data.models.RegisterResponseModel

interface AppApi {

    // TODO
    //  1. Добавить все запросы и у всех указать тип (Post, Get, итд) и ссылку
    //  2. Указать query параметры, если есть или params (к названию модели лучше добавлять "RequestModel")
    //  3. Добавить вид ответа от сервера в виде модельки. Например, как LoginResponseModel

    @POST("customers/login")
    suspend fun login(@Body params: LoginRequestModel): Response<LoginResponseModel>

    @POST("customers/register")
    suspend fun register(@Body params: RegisterRequestModel): Response<RegisterResponseModel>

    @GET("products/all")
    suspend fun allProducts(): Response<GetAllProductsResponseModel>

}