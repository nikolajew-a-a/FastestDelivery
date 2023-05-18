package ru.app.fastestdelivery.presentation.main.profile

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

}