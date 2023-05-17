package ru.app.fastestdelivery.domain

import ru.app.fastestdelivery.data.Repository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun login(email: String, password: String) {
        repository.login(email = email, password = password)
    }

    suspend fun register(name: String, email: String, password: String) {
        repository.register(name = name, email = email, password = password)
    }

}