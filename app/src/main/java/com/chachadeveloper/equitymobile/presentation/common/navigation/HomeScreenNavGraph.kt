package com.chachadeveloper.equitymobile.presentation.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation


fun NavGraphBuilder.homeScreenNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.HOME,
        startDestination = ""
    ){


    }
}

sealed class HomeScreen(val route: String){
    object SendMoneyToAccount: HomeScreen(route = "Send_Money_To_Account")
    object MobileMoney: HomeScreen(route = "Mobile Money")
    object AnotherAccount: HomeScreen(route = "Another Account")
    object PayBill: HomeScreen(route = "Paybill")
}