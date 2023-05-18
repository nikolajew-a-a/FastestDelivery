package ru.app.fastestdelivery.presentation.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.app.fastestdelivery.R
import ru.app.fastestdelivery.databinding.FragmentMainBinding
import ru.app.fastestdelivery.presentation.auth.login.LoginFragment
import ru.app.fastestdelivery.presentation.auth.models.AuthTab
import ru.app.fastestdelivery.presentation.auth.register.RegisterFragment
import ru.app.fastestdelivery.presentation.main.bag.BagFragment
import ru.app.fastestdelivery.presentation.main.home.HomeFragment
import ru.app.fastestdelivery.presentation.main.profile.ProfileFragment
import ru.app.fastestdelivery.util.observe

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewBinding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()

    private val tabFragments by lazy {
        mapOf(
            R.id.menu_home to HomeFragment.newInstance(),
            R.id.menu_bag to BagFragment.newInstance(),
            R.id.menu_profile to ProfileFragment.newInstance()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews() = with(viewBinding) {
        mainBottomNavigation.setOnNavigationItemSelectedListener { item ->
            viewModel.onTabClicked(item.itemId)
            true
        }
    }

    private fun initObservers() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            tabFragments[state.selectedTabId]?.let { fragment ->
                childFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit()
            }
        }
    }

    companion object {

        fun newInstance() = MainFragment()

    }

}