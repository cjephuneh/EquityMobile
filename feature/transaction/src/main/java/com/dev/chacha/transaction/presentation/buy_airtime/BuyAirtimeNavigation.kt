package com.dev.chacha.transaction.presentation.buy_airtime

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.transaction.presentation.transaction.TransactionScreen
import com.dev.chacha.util.Graph.BUY_AIRTIME_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE

fun NavGraphBuilder.buyAirtimeNavGraph(
    navController: NavHostController
) {
    composable(route = BUY_AIRTIME_ROUTE) {
        BuyAirtimeScreen()
    }

}

