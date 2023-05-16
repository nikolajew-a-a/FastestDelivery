package ru.app.fastestdelivery.presentation.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentLoginBinding
import ru.app.fastestdelivery.databinding.FragmentRegisterBinding
import ru.app.fastestdelivery.presentation.auth.login.LoginViewModel

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private val viewBinding: FragmentRegisterBinding by viewBinding(FragmentRegisterBinding::bind)
    private val viewModel: RegisterViewModel by viewModels()

    companion object {

        fun newInstance() = RegisterFragment()

    }

}