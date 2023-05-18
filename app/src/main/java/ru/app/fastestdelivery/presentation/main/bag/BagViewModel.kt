package ru.app.fastestdelivery.presentation.main.bag

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.app.fastestdelivery.presentation.screens.Screens
import javax.inject.Inject

@HiltViewModel
class BagViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    fun onPayButtonClicker() {
        router.navigateTo(Screens.paymentResultScreen())
    }

}