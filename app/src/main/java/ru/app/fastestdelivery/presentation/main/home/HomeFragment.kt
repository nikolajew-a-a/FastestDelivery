package ru.app.fastestdelivery.presentation.main.home

import android.os.Bundle
import android.view.View
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(viewBinding) {
        // TODO (эту кнопка временная и нужна только для демонстрации навигации на детальную карточку продукта,
        //  ее нужно будет удалить, а листенер уже использовать во viewHolder для recyclerView)
        this.tempButton.setOnClickListener {
            viewModel.onProductClicked(productId = 0)
        }
    }

    companion object {

        fun newInstance() = HomeFragment()

    }

}