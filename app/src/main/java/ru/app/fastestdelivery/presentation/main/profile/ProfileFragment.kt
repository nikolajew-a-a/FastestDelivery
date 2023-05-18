package ru.app.fastestdelivery.presentation.main.profile

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

    companion object {

        fun newInstance() = ProfileFragment()

    }

}