package ru.app.fastestdelivery.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewBinding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(viewBinding) {
        mainBottomNavigation.setOnNavigationItemReselectedListener { item ->
            when(val itemId = item.itemId) {
                R.id.menu_home -> {
                    // Respond to navigation item 1 reselection
                }
                R.id.menu_bag -> {
                    // Respond to navigation item 2 reselection
                }
                R.id.menu_profile -> {
                    // Respond to navigation item 2 reselection
                }
            }
        }
    }

    companion object {

        fun newInstance() = MainFragment()

    }

}