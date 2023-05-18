package ru.app.fastestdelivery.data

import retrofit2.Response
import ru.app.fastestdelivery.data.api.AppApi
import ru.app.fastestdelivery.data.converters.user.UserEntityToModel
import ru.app.fastestdelivery.data.converters.user.UserResponseToEntity
import ru.app.fastestdelivery.data.errors.ErrorResponse
import ru.app.fastestdelivery.data.errors.ErrorsConverter
import ru.app.fastestdelivery.data.models.network.CreateOrderRequestModel
import ru.app.fastestdelivery.data.models.network.CreateOrderResponseModel
import ru.app.fastestdelivery.data.models.network.GetAllProductsResponseModel
import ru.app.fastestdelivery.data.models.network.LoginRequestModel
import ru.app.fastestdelivery.data.models.network.RegisterRequestModel
import ru.app.fastestdelivery.data.room.UserDao
import ru.app.fastestdelivery.domain.User
import ru.app.fastestdelivery.util.MessageException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val api: AppApi,
    private val userDao: UserDao,
    private val errorsConverter: ErrorsConverter,
    private val userResponseToEntity: UserResponseToEntity,
    private val userEntityToModel: UserEntityToModel,
) {

    suspend fun login(email: String, password: String) {
        val params = LoginRequestModel(email = email, password = password)
        val response = api.login(params = params)
        if (response.isSuccessful) {
            userDao.insertUser(userResponseToEntity.convert(response.body()!!))
        } else {
            throw MessageException(message = errorMessage(response))
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