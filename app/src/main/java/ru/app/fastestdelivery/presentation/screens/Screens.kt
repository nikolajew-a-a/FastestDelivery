package ru.app.fastestdelivery.presentation.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.app.fastestdelivery.presentation.auth.AuthFragment
import ru.app.fastestdelivery.presentation.main.MainFragment
import ru.app.fastestdelivery.presentation.splash.SplashFragment

object Screens {

    private const val SPLASH_SCREEN_NAME = "SPLASH_SCREEN_NAME"
    private const val LOGIN_SCREEN_NAME = "LOGIN_SCREEN_NAME"
    private const val MAIN_SCREEN_NAME = "MAIN_SCREEN_NAME"

    fun splashScreen() = FragmentScreen(SPLASH_SCREEN_NAME) {
        SplashFragment.newInstance()
    }

    fun loginScreen() = FragmentScreen(LOGIN_SCREEN_NAME) {
        AuthFragment.newInstance()
    }

    fun mainScreen() = FragmentScreen(MAIN_SCREEN_NAME) {
        MainFragment.newInstance()
    }

}