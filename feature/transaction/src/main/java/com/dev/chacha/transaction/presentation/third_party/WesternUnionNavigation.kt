package com.dev.chacha.transaction.presentation.third_party

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.transaction.presentation.transaction.TransactionScreen
import com.dev.chacha.util.Graph.BUY_AIRTIME_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE
import com.dev.chacha.util.Graph.WESTERN_UNION_ROUTE

fun NavGraphBuilder.westernUnionNavGraph(
    navController: NavHostController
) {
    composable(route = WESTERN_UNION_ROUTE) {
        WesternUnionScreen()
    }

}

