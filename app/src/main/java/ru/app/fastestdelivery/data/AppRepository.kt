package ru.app.fastestdelivery.data

import retrofit2.Response
import ru.app.fastestdelivery.data.api.AppApi
import ru.app.fastestdelivery.data.errors.ErrorResponse
import ru.app.fastestdelivery.data.errors.ErrorsConverter
import ru.app.fastestdelivery.data.models.network.CreateOrderRequestModel
import ru.app.fastestdelivery.data.models.network.CreateOrderResponseModel
import ru.app.fastestdelivery.data.models.network.GetAllProductsResponseModel
import ru.app.fastestdelivery.data.models.network.LoginRequestModel
import ru.app.fastestdelivery.data.models.network.RegisterRequestModel
import ru.app.fastestdelivery.util.MessageException
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: AppApi,
    private val errorsConverter: ErrorsConverter
) {

    suspend fun login(email: String, password: String) {
        val params = LoginRequestModel(
            email = email,
            password = password
        )
        api.login(params = params).also {
            if (it.isSuccessful) {
                // TODO (Добавить сохранение в БД)
            } else {
                throw MessageException(message = errorMessage(it))
            }
        }
    }

    suspend fun register(name: String, email: String, password: String) {
        val params = RegisterRequestModel(
                name = name,
                email = email,
                password = password
        )
        api.register(params = params)
    }

    suspend fun getAllProducts(): Response<GetAllProductsResponseModel> = api.allProducts()

    suspend fun createOrder(customerId: Int, price: Double, status: String): Response<CreateOrderResponseModel> {
        val params = CreateOrderRequestModel(
                customerId = customerId,
                price = price,
                status = status
        )
        return api.createOrder(params = params)
    }

    suspend fun getOrders(customerId: Int) = api.getOrders(customerId = customerId)

    private fun errorMessage(response: Response<*>): String {
        return errorsConverter.convert(
                jsonString = response.errorBody()?.string().orEmpty(),
                type = ErrorResponse::class.java
            )
            ?.message
            .orEmpty()
    }

}