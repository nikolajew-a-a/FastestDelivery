package ru.app.fastestdelivery.presentation.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentLoginBinding

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewBinding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(viewBinding) {
        loginContinueButton.setOnClickListener {
            viewModel.onContinueButtonClicked()
        }
    }

    companion object {

        fun newInstance() = LoginFragment()

    }

}