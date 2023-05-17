package ru.app.fastestdelivery.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.app.fastestdelivery.domain.AuthUseCase
import ru.app.fastestdelivery.presentation.screens.Screens
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val router: Router,
): ViewModel() {

    fun onContinueButtonClicked() {
        // TODO(Нужно добавить валидацию полей + запрос на сервер)

        viewModelScope.launch {
            authUseCase.login(
                email = "",
                password = ""
            )
        }
        router.navigateTo(Screens.mainScreen())
    }

}