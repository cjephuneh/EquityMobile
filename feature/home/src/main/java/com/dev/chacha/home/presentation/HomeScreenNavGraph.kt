package com.dev.chacha.home.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dev.chacha.home.presentation.home_screen.HomeScreen
import com.dev.chacha.util.Graph
import com.dev.chacha.util.Graph.HOME_SCREEN_ROUTE


fun NavGraphBuilder.homeScreenNavGraph(navController: NavHostController) {
    composable(route = HOME_SCREEN_ROUTE) {
        HomeScreen(
            onClickAction = {},
            navController = navController
        )
    }
}

sealed class HomeScreen(val route: String){
    object SendMoneyToAccount: HomeScreen(route = "Send_Money_To_Account")
    object MobileMoney: HomeScreen(route = "Mobile Money")
    object AnotherAccount: HomeScreen(route = "Another Account")
    object PayBill: HomeScreen(route = "Paybill")
}