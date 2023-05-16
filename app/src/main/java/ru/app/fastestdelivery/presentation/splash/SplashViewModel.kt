package ru.app.fastestdelivery.presentation.splash

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.app.fastestdelivery.presentation.screens.Screens
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val router: Router
): ViewModel() {

    fun continueButtonClicked() {
        router.navigateTo(Screens.loginScreen())
    }

}