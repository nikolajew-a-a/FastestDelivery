package ru.app.fastestdelivery.presentation.main.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentBagBinding
import ru.app.fastestdelivery.databinding.FragmentProfileBinding

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val viewBinding: FragmentProfileBinding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniViews()
    }

    private fun iniViews() = with(viewBinding) {
        profileLogoutButton.setOnClickListener {
            viewModel.onLogoutClicked()
        }
    }

    companion object {

        fun newInstance() = ProfileFragment()

    }

}