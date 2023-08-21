package com.dev.chacha.transaction.presentation.pay_with_Equity

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.transaction.presentation.transaction.TransactionScreen
import com.dev.chacha.util.Graph.BUY_AIRTIME_ROUTE
import com.dev.chacha.util.Graph.BUY_GOODS_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE

fun NavGraphBuilder.buyGoodsNavGraph(
    navController: NavHostController
) {
    composable(route = BUY_GOODS_ROUTE) {
        BuyGoodScreen()
    }

}

