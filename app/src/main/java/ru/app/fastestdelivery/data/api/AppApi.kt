package ru.app.fastestdelivery.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import ru.app.fastestdelivery.data.models.LoginRequestModel
import ru.app.fastestdelivery.data.models.LoginResponseModel

interface AppApi {

    // TODO
    //  1. Добавить все запросы и у всех указать тип (Post, Get, итд) и ссылку
    //  2. Указать query параметры, если есть или params (к названию модели лучше добавлять "RequestModel")
    //  3. Добавить вид ответа от сервера в виде модельки. Например, как LoginResponseModel

    @POST("/register")
    suspend fun login(@Body params: LoginRequestModel): Response<LoginResponseModel>

}