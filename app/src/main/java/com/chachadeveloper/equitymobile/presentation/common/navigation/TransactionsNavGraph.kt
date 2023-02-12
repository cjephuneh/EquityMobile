package com.chachadeveloper.equitymobile.presentation.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dev.chacha.transaction.presentation.transaction_screen.TransactionScreen

fun NavGraphBuilder.transactionNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.TRANSACTION_DETAILS,
        startDestination = TransactionScreen.Agent.route
    ){
        composable(route = TransactionScreen.Agent.route){
            TransactionScreen()

        }

    }
}





sealed class TransactionScreen(val route: String){
    object OwnEquityAccount: TransactionScreen(route="own_equity")
    object AnotherEquityAccount: TransactionScreen(route="another_equity_account")
    object TopUpCard: TransactionScreen(route="topupcard")
    object MobileWallet: TransactionScreen(route="mobile-wallet")
    object AnotherBank: TransactionScreen(route="another-bank")
    object PayBill: TransactionScreen(route="playbill")
    object BuyGoods: TransactionScreen(route="buy goods")
    object BuyAirtime: TransactionScreen(route="buy-airtime")
    object Agent: TransactionScreen(route="agent")
}