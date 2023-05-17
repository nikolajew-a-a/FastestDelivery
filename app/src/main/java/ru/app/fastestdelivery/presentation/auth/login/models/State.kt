package ru.app.fastestdelivery.presentation.auth.login.models

import ru.app.fastestdelivery.util.InputState

data class State(
    val email: InputState<String>,
    val password: InputState<String>
)