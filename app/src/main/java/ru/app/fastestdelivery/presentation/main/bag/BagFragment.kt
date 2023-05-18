package ru.app.fastestdelivery.presentation.main.bag

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentBagBinding

@AndroidEntryPoint
class BagFragment : Fragment(R.layout.fragment_bag) {

    private val viewBinding: FragmentBagBinding by viewBinding(FragmentBagBinding::bind)
    private val viewModel: BagViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(viewBinding) {
        bagBuyButton.setOnClickListener {
            viewModel.onBuyButtonClicked()
        }
    }

    companion object {

        fun newInstance() = BagFragment()

    }

}