package com.dev.chacha.transaction.presentation.withdraw_cash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.transaction.presentation.transaction.TransactionScreen
import com.dev.chacha.util.Graph.BUY_AIRTIME_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE
import com.dev.chacha.util.Graph.WITHDRAW_CASH_AGENT_ROUTE

fun NavGraphBuilder.withDrawCashAgentNavGraph(
    navController: NavHostController
) {
    composable(route = WITHDRAW_CASH_AGENT_ROUTE) {
        WithdrawCashAgentScreen(navController)
    }

}

