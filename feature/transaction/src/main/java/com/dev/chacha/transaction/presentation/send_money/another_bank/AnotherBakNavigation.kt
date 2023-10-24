package com.dev.chacha.transaction.presentation.send_money.another_bank

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.util.Graph.ANOTHER_BANK_ROUTE

fun NavGraphBuilder.anotherBankNavGraph(
    navController: NavHostController
) {
    composable(route = ANOTHER_BANK_ROUTE) {
        AnotherBankScreen(navController)
    }

}

