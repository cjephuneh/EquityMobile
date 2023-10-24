package com.dev.chacha.loans.presentation.my_loans

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.util.Graph

fun NavGraphBuilder.myLoanNavGraph(navController: NavHostController) {
    composable(route = Graph.MY_LOANS_SCREEN_ROUTE) {
        MyLoanAccountScreen()
    }
}