package ru.app.fastestdelivery.presentation.main.bag

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BagViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

}