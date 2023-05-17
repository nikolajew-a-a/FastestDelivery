package ru.app.fastestdelivery.presentation.auth.login

import android.text.Editable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.app.fastestdelivery.domain.AuthUseCase
import ru.app.fastestdelivery.presentation.screens.Screens
import javax.inject.Inject
import ru.app.fastestdelivery.presentation.auth.login.models.State
import ru.app.fastestdelivery.util.ui.inputState.InputState

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val router: Router,
): ViewModel() {

    private val initialState = State(
        email = InputState.Data(""),
        password = InputState.Data("")
    )
    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    fun onContinueButtonClicked() {
        val email = (_state.value.email as? InputState.Data)?.value.orEmpty()
        if (email.isBlank()) {
            _state.update { it.copy(email = InputState.Error.EmptyInput) }
        }

        val password = (_state.value.password as? InputState.Data)?.value.orEmpty()
        if (password.isBlank()) {
            _state.update { it.copy(password = InputState.Error.EmptyInput) }
        }

        if (_state.value.email.isError() || _state.value.password.isError()) return

        viewModelScope.launch {
            authUseCase.login(
                email = email,
                password = password
            )
            router.navigateTo(Screens.mainScreen())
        }
    }

    fun onEmailUpdated(email: Editable?) {
        _state.update { it.copy(email = InputState.Data(email.toString())) }
    }

    fun onPasswordUpdated(password: Editable?) {
        _state.update { it.copy(password = InputState.Data(password.toString())) }
    }

}