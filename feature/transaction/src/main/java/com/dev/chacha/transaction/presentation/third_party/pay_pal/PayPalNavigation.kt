package com.dev.chacha.transaction.presentation.third_party.pay_pal

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.util.Graph.PAYPAL_ROUTE
import com.dev.chacha.util.Graph.WITHDRAW_FROM_PAYPAL_ROUTE

fun NavGraphBuilder.payPalNavGraph(
    navController: NavHostController
) {
    composable(route = PAYPAL_ROUTE) {
        PayPalScreen(navController)
    }
    composable(PayPalNavigation.WithdrawFromPayPal.route){
        WithdrawFromPayPalSheet(
            navController = navController,
            onNavigateBack = {
                navController.popBackStack(
                    route = WITHDRAW_FROM_PAYPAL_ROUTE,
                    inclusive = false
                )
            }
        )
    }

    composable(WITHDRAW_FROM_PAYPAL_ROUTE){
        PayPalFirstScreenSheet(navController)
    }

}

sealed class PayPalNavigation(val route: String) {
    object WithdrawFromPayPal : PayPalNavigation("withdraw_from_paypal")
    object PayPalFirstScreenSheet : PayPalNavigation("first_from_paypal")
}

