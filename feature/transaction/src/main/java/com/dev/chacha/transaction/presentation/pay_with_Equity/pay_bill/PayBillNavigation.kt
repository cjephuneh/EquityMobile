package com.dev.chacha.transaction.presentation.pay_with_Equity.pay_bill

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.util.Graph.PAY_BILL_ROUTE

fun NavGraphBuilder.payBillNavGraph(
    navController: NavHostController
) {
    composable(route = PAY_BILL_ROUTE) {
        PayBillScreen(navController)
    }

}

