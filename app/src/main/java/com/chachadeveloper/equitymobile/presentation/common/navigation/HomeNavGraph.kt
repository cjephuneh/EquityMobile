package com.chachadeveloper.equitymobile.presentation.common.navigation

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                onClickAction = {
                    navController.navigate(Graph.BORROW_DETAILS)
                }
            )

        }
        composable(BottomBarScreen.Transaction.route){
            showBottomBar(true)
            TransactionScreen()

        }
        composable(BottomBarScreen.Borrow.route){
            showBottomBar(true)
            BorrowScreen()

        }

        composable(BottomBarScreen.Savings.route){
            showBottomBar(true)
            SavingsScreen()

        }
        composable(BottomBarScreen.More.route){
            showBottomBar(true)
            MoreScreen()

        }

        /*moreScreenNavGraph(navController = navController)
//        transactionNavGraph(navController = navController)
        borrowNavGraph(navController = navController)
        homeScreenNavGraph(navController = navController)*/

    }

}



sealed class BottomBarScreen(val route: String, @DrawableRes val icon: Int, val title: String){
    object Home: BottomBarScreen("home", R.drawable.home, "Home")
    object Transaction: BottomBarScreen("transaction",R.drawable.transact,"Transact")
    object Borrow: BottomBarScreen("loan",R.drawable.loan,"Borrow")
    object Savings: BottomBarScreen("savings", R.drawable.transact,"Save")
    object More: BottomBarScreen("more",R.drawable.more,"More")
}

val bottomNavigationItems = listOf(
    BottomBarScreen.Home,
    BottomBarScreen.Transaction,
    BottomBarScreen.Borrow,
    BottomBarScreen.Savings,
    BottomBarScreen.More
)