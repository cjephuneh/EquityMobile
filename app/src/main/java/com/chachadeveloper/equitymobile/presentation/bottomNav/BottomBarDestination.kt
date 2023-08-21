package com.chachadeveloper.equitymobile.presentation.bottomNav

import androidx.annotation.DrawableRes
import com.chachadeveloper.equitymobile.R
import com.dev.chacha.util.Graph.BORROW_SCREEN_ROUTE
import com.dev.chacha.util.Graph.HOME_SCREEN_ROUTE
import com.dev.chacha.util.Graph.MORE_SCREEN_ROUTE
import com.dev.chacha.util.Graph.SAVINGS_SCREEN_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE

enum class BottomBarDestination(val route: String, @DrawableRes val icon: Int, val title: String) {
    HOME(HOME_SCREEN_ROUTE, R.drawable.home4, "Home"),
    TRANSACTION(TRANSACTION_SCREEN_ROUTE, R.drawable.transact, "Transact"),
    BORROW(BORROW_SCREEN_ROUTE, R.drawable.loan, "Borrow"),
    SAVINGS(SAVINGS_SCREEN_ROUTE, R.drawable.spa, "Save"),
    MORE(MORE_SCREEN_ROUTE, R.drawable.more, "More")

}