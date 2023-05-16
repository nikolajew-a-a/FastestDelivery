package ru.app.fastestdelivery.presentation.auth.login

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.app.fastestdelivery.presentation.screens.Screens
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val router: Router,
): ViewModel() {

    fun onContinueButtonClicked() {
        // TODO(Нужно добавить валидацию полей + запрос на сервер)
        router.navigateTo(Screens.mainScreen())
    }

}