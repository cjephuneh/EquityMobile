package com.dev.chacha.transaction.presentation.buy_airtime

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.transaction.presentation.buy_airtime.bottom_sheet.BuyAirtimeBottomSheet
import com.dev.chacha.transaction.presentation.buy_airtime.bottom_sheet.BuyAirtimeCountrySearch
import com.dev.chacha.transaction.presentation.transaction.TransactionScreen
import com.dev.chacha.util.Graph.BUY_AIRTIME_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE
import okhttp3.Route

fun NavGraphBuilder.buyAirtimeNavGraph(
    navController: NavHostController
) {
    composable(route = BUY_AIRTIME_ROUTE) {
        BuyAirtimeScreen(navController)
    }
    composable(route = BuyAirtimeNavigation.FirstBottomSheet.route) {
       BuyAirtimeBottomSheet()
    }

     composable(route = BuyAirtimeNavigation.SecondBottomSheet.route) {
         BuyAirtimeCountrySearch()
    }




}

sealed class BuyAirtimeNavigation(val route: String){
    object FirstBottomSheet: BuyAirtimeNavigation("first-sheet")
    object SecondBottomSheet: BuyAirtimeNavigation("second-sheet")
}

