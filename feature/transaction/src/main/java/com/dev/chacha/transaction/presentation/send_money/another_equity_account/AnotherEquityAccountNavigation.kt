package com.dev.chacha.transaction.presentation.send_money.another_equity_account

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.util.Graph.ANOTHER_EQUITY_ACCOUNT_ROUTE

fun NavGraphBuilder.anotherEquityAccountNavGraph(
    navController: NavHostController
) {
    composable(route = ANOTHER_EQUITY_ACCOUNT_ROUTE) {
        AnotherEquityAccountScreen(navController)
    }

}

