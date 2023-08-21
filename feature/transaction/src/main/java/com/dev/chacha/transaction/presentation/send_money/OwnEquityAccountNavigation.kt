package com.dev.chacha.transaction.presentation.send_money

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.transaction.presentation.transaction.TransactionScreen
import com.dev.chacha.util.Graph.BUY_AIRTIME_ROUTE
import com.dev.chacha.util.Graph.OWN_EQUITY_ACCOUNT_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE

fun NavGraphBuilder.ownEquityAccountNavGraph(
    navController: NavHostController
) {
    composable(route = OWN_EQUITY_ACCOUNT_ROUTE) {
        OwnEquityAccountScreen()
    }

}

