package ru.app.fastestdelivery.presentation.splash

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewBinding: FragmentSplashBinding by viewBinding(FragmentSplashBinding::bind)

    companion object {

        fun newInstance() = SplashFragment()

    }
}