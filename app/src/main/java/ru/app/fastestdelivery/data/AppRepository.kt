package ru.app.fastestdelivery.data

import ru.app.fastestdelivery.data.api.AppApi
import ru.app.fastestdelivery.data.models.LoginRequestModel
import ru.app.fastestdelivery.data.models.RegisterRequestModel
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

    suspend fun register(name: String, email: String, password: String) {
        val params = RegisterRequestModel(
                name = name,
                email = email,
                password = password
        )
        api.register(params = params)
    }

}