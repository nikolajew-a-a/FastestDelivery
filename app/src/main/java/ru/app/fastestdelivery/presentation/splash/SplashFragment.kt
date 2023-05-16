package ru.app.fastestdelivery.presentation.splash

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentSplashBinding

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewBinding: FragmentSplashBinding by viewBinding(FragmentSplashBinding::bind)
    private val viewModel: SplashViewModel by viewModels()

    companion object {

        fun newInstance() = SplashFragment()

    }

}