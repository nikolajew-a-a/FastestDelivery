package ru.app.fastestdelivery.data

import ru.app.fastestdelivery.data.api.AppApi
import ru.app.fastestdelivery.data.models.LoginRequestModel
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: AppApi
) {

    suspend fun login(email: String, password: String) {
        val params = LoginRequestModel(
            email = email,
            password = password
        )
        api.login(params = params)
    }

    suspend fun register(email: String, password: String) {

    }

}