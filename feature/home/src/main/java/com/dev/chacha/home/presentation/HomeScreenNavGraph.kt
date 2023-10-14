package com.dev.chacha.home.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.home.presentation.home_screen.HomeScreen
import com.dev.chacha.home.presentation.transaction_history.AccountCardScreen
import com.dev.chacha.util.Graph.HOME_SCREEN_ROUTE


fun NavGraphBuilder.homeScreenNavGraph(navController: NavHostController) {
    composable(route = HOME_SCREEN_ROUTE) {
        HomeScreen(
            onClickAction = {},
            navController = navController
        )
    }

    composable(HomeNavigation.AccountCard.route){
        AccountCardScreen()
    }
}

sealed class HomeNavigation(val route: String){
    object SendMoneyToAccount: HomeNavigation(route = "Send_Money_To_Account")
    object MobileMoney: HomeNavigation(route = "Mobile Money")
    object AnotherAccount: HomeNavigation(route = "Another Account")
    object PayBill: HomeNavigation(route = "Paybill")
    object AccountCard: HomeNavigation("account_cards")
}