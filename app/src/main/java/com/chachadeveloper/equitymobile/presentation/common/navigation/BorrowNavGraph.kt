package com.chachadeveloper.equitymobile.presentation.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dev.chacha.loans.presentation.get_loan_screen.GetLoanScreen
import com.dev.chacha.loans.presentation.pay_loan_screen.PayLoanScreen

fun NavGraphBuilder.borrowNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.BORROW_DETAILS,
        startDestination = BorrowScreen.GetLoan.route
    ) {
        composable(route = BorrowScreen.GetLoan.route) {
            GetLoanScreen() {
                navController.navigate(BorrowScreen.CheckLoanLimit.route)
            }
        }
        composable(route = BorrowScreen.PayLoan.route) {
            PayLoanScreen() {
                navController.popBackStack(
                    route = BorrowScreen.CheckLoanLimit.route,
                    inclusive = false
                )
            }
        }
    }

}


sealed class BorrowScreen(val route: String){
    object GetLoan: BorrowScreen(route= "get_loan")
    object PayLoan: BorrowScreen( route = "pay_loan")
    object CheckLoanLimit: BorrowScreen(route = "Check_loan")
}