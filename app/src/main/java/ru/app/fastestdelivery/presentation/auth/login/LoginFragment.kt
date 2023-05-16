package ru.app.fastestdelivery.presentation.auth.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewBinding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels()

    companion object {

        fun newInstance() = LoginFragment()

    }

}