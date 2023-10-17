package com.chachadeveloper.equitymobile.presentation.bottomNav

import androidx.annotation.DrawableRes
import com.chachadeveloper.equitymobile.R
import com.dev.chacha.util.Graph.ACCOUNTS_SCREEN_ROUTE
import com.dev.chacha.util.Graph.HOME_SCREEN_ROUTE
import com.dev.chacha.util.Graph.MORE_SCREEN_ROUTE

enum class BottomBarDestination(val route: String, @DrawableRes val icon: Int, val title: String) {
    ACCOUNTS(ACCOUNTS_SCREEN_ROUTE, R.drawable.home4, "Accounts"),
    SETTINGS(MORE_SCREEN_ROUTE, R.drawable.outline_settings_24, "Settings")
}