package com.dev.chacha.transaction.presentation.send_money.own_equity_bank

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.util.Graph.OWN_EQUITY_ACCOUNT_ROUTE

fun NavGraphBuilder.ownEquityAccountNavGraph(
    navController: NavHostController
) {
    composable(route = OWN_EQUITY_ACCOUNT_ROUTE) {
        OwnEquityAccountScreen(navController)
    }

}

