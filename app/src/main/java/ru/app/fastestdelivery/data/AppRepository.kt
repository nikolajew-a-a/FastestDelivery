package ru.app.fastestdelivery.data

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import ru.app.fastestdelivery.data.api.AppApi
import ru.app.fastestdelivery.data.models.CreateOrderRequestModel
import ru.app.fastestdelivery.data.models.CreateOrderResponseModel
import ru.app.fastestdelivery.data.models.GetAllProductsResponseModel
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

}