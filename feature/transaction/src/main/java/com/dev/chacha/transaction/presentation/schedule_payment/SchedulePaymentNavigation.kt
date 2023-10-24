package com.dev.chacha.transaction.presentation.schedule_payment

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.transaction.presentation.transaction.TransactionScreen
import com.dev.chacha.util.Graph.BUY_AIRTIME_ROUTE
import com.dev.chacha.util.Graph.SCHEDULE_PAYMENT_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE

fun NavGraphBuilder.schedulePaymentNavGraph(
    navController: NavHostController
) {
    composable(route = SCHEDULE_PAYMENT_ROUTE) {
        SchedulePaymentScreen(navController)
    }

}

