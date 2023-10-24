package com.dev.chacha.transaction.presentation.send_money.pay_to_card

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.util.Graph.PAY_TO_CARD_ROUTE

fun NavGraphBuilder.payToCardNavGraph(
    navController: NavHostController
) {
    composable(route = PAY_TO_CARD_ROUTE) {
        PayToCardScreen(navController)
    }

}

