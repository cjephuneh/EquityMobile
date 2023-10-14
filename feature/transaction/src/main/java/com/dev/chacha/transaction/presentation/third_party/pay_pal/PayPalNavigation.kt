package com.dev.chacha.transaction.presentation.third_party.pay_pal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.transaction.presentation.TransactionNavigation
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import com.dev.chacha.util.Graph.PAYPAL_ROUTE

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
                    route = PayPalNavigation.PayPalFirstScreenSheet.route,
                    inclusive = false
                )
            }
        )
    }

    composable(PayPalNavigation.PayPalFirstScreenSheet.route){
        PayPalFirstScreenSheet(navController)
    }

}

sealed class PayPalNavigation(val route: String) {
    object WithdrawFromPayPal : PayPalNavigation("withdraw_from_paypal")
    object PayPalFirstScreenSheet : PayPalNavigation("first_from_paypal")
}

