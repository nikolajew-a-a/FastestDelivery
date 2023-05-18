package ru.app.fastestdelivery.presentation.main.bag

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentBagBinding
import ru.app.fastestdelivery.databinding.FragmentHomeBinding

@AndroidEntryPoint
class BagFragment : Fragment(R.layout.fragment_bag) {

    private val viewBinding: FragmentBagBinding by viewBinding(FragmentBagBinding::bind)
    private val viewModel: BagViewModel by viewModels()

    companion object {

        fun newInstance() = BagFragment()

    }

}