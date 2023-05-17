package ru.app.fastestdelivery.data

import ru.app.fastestdelivery.data.api.AppApi
import ru.app.fastestdelivery.data.models.LoginRequestModel

class Repository(
    private val api: AppApi
) {

    suspend fun login(email: String, password: String) {
        val params = LoginRequestModel(
            email = email,
            password = password
        )
        api.login(
            email = email,
            password = password,
            params = params
        )
    }

    suspend fun register(email: String, password: String) {

    }

}