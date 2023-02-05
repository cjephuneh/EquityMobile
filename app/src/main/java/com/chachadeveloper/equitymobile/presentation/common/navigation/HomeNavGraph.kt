package com.chachadeveloper.equitymobile.common.navigation

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dev.chacha.home.presentation.home_screen.HomeScreen
import com.dev.chacha.loans.presentation.borrow_screen.BorrowScreen
import com.dev.chacha.more.presentation.more_screen.MoreScreen
import com.dev.chacha.savings.presentation.SavingsScreen
import com.dev.chacha.transaction.presentation.transaction_screen.TransactionScreen
import com.dev.chacha.ui.R


@Composable
fun HomeNavGraph(
    navController: NavHostController,
    showBottomBar: (Boolean) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route ,
        route = Graph.HOME
    ){
        composable(BottomBarScreen.Home.route){
            showBottomBar(true)
            HomeScreen(
                /*onClickAction = {
                    navController.navigate(Graph.DETAILS)
                }*/
            )

        }
        composable(BottomBarScreen.Transaction.route){
            showBottomBar(true)
            TransactionScreen(
//                onClickAction = {}
            )

        }
        composable(BottomBarScreen.Loan.route){
            showBottomBar(true)
            BorrowScreen (
               /* navigateToLogin = {
                    navController.navigate(BottomBarScreen.Accoun.route)
                }*/
            )

        }

        composable(BottomBarScreen.Savings.route){
            showBottomBar(true)
            SavingsScreen()

        }
        composable(BottomBarScreen.More.route){
            showBottomBar(true)
            MoreScreen()

        }
//        detailsNavGraph(navController = navController)

    }

}

/*fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            Information() {
                navController.navigate(DetailsScreen.Overview.route)
            }
        }
        composable(route = DetailsScreen.Overview.route) {
            Overview() {
                navController.popBackStack(
                    route = DetailsScreen.Information.route,
                    inclusive = false
                )
            }
        }
    }
}*/



sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
    object Overview : DetailsScreen(route = "OVERVIEW")
}


sealed class BottomBarScreen(val route: String, @DrawableRes val icon: Int, val title: String){
    object Home: BottomBarScreen("home", R.drawable.home, "Home")
    object Transaction: BottomBarScreen("transaction",R.drawable.transact,"Transact")
    object Loan: BottomBarScreen("loan",R.drawable.loan,"Borrow")
    object Savings: BottomBarScreen("savings", R.drawable.transact,"Save")
    object More: BottomBarScreen("more",R.drawable.more,"More")
}

val bottomNavigationItems = listOf(
    BottomBarScreen.Home,
    BottomBarScreen.Transaction,
    BottomBarScreen.Loan,
    BottomBarScreen.Savings,
    BottomBarScreen.More
)