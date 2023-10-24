package com.dev.chacha.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.home.presentation.transaction_history.AccountCardScreen
import com.dev.chacha.util.Graph.ACCOUNTS_SCREEN_ROUTE


fun NavGraphBuilder.accountScreenNavGraph(navController: NavHostController) {
    composable(route = ACCOUNTS_SCREEN_ROUTE) {
        AccountCardScreen()
    }

}
