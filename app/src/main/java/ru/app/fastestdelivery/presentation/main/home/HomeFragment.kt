package ru.app.fastestdelivery.presentation.main.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewBinding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()

    companion object {

        fun newInstance() = HomeFragment()

    }

}