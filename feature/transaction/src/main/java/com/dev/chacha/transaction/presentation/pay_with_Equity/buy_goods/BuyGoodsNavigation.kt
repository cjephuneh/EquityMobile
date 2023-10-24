package com.dev.chacha.transaction.presentation.pay_with_Equity.buy_goods

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.transaction.presentation.pay_with_Equity.buy_goods.BuyGoodScreen
import com.dev.chacha.util.Graph.BUY_GOODS_ROUTE

fun NavGraphBuilder.buyGoodsNavGraph(
    navController: NavHostController
) {
    composable(route = BUY_GOODS_ROUTE) {
        BuyGoodScreen(navController)
    }

}

