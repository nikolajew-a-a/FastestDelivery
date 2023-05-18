package ru.app.fastestdelivery.presentation.paymentResult

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaymentResultViewModel @Inject constructor(
    private val router: Router
): ViewModel() {

    fun onContinueClicked() {
        router.exit()
    }

}