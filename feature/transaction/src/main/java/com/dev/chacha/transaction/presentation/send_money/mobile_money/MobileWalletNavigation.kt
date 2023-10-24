package com.dev.chacha.transaction.presentation.send_money.mobile_money

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.util.Graph.MOBILE_WALLET_ROUTE

fun NavGraphBuilder.mobileWalletNavGraph(
    navController: NavHostController
) {
    composable(route = MOBILE_WALLET_ROUTE) {
        MobileWalletScreen(navController)
    }

}

