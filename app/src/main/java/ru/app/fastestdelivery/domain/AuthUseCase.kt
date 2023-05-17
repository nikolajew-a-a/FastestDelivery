package ru.app.fastestdelivery.domain

import ru.app.fastestdelivery.data.Repository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun login(email: String, password: String) {
        repository.login(email = email, password = password)
    }

    suspend fun register(email: String, password: String) {
        repository.register(email = email, password = password)
    }

}