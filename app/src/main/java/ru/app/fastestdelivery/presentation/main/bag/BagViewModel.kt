package ru.app.fastestdelivery.presentation.main.bag

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.domain.BagProductsUseCase
import ru.app.fastestdelivery.presentation.main.bag.models.State
import ru.app.fastestdelivery.presentation.screens.Screens
import javax.inject.Inject

@HiltViewModel
class BagViewModel @Inject constructor(
    private val bagProductsUseCase: BagProductsUseCase,
    private val router: Router
) : ViewModel() {

    private val initialState = State(items = emptyList())
    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        observeBagProducts()
    }

    fun onBuyButtonClicked() {
        router.navigateTo(Screens.paymentResultScreen())
    }

    private fun observeBagProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            bagProductsUseCase.getBagProductsFlow().collect { products ->
                _state.update { it.copy(items = products) }
            }
        }
    }

}