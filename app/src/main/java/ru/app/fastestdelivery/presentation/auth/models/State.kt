package ru.app.fastestdelivery.presentation.auth.models

import androidx.fragment.app.Fragment

data class State(
    val selectedTab: AuthTab,
    val fragments: Map<AuthTab, Fragment>
)