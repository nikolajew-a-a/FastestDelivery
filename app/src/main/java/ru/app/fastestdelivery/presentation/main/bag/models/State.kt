package ru.app.fastestdelivery.presentation.main.bag.models

import ru.app.fastestdelivery.domain.models.Product

data class State(
    val items: List<Product>
)