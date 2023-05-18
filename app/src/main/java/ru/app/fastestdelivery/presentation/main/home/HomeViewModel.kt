package ru.app.fastestdelivery.presentation.main.home

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.app.fastestdelivery.presentation.screens.Screens
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    fun onProductClicked(productId: Int) {
        router.navigateTo(Screens.productDetailScreen(productId = productId))
    }

}