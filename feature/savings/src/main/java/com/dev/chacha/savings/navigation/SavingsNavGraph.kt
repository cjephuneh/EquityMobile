package com.dev.chacha.savings.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.savings.presentation.SavingsScreen
import com.dev.chacha.savings.presentation.call_deposit.AboutCallDepositScreen
import com.dev.chacha.savings.presentation.call_deposit.CallDepositScreen
import com.dev.chacha.savings.presentation.classic_savings.AboutClassicSavingsScreen
import com.dev.chacha.savings.presentation.classic_savings.ClassicSavingsScreen
import com.dev.chacha.savings.presentation.fixed_deposit.AboutFixedDepositScreen
import com.dev.chacha.savings.presentation.fixed_deposit.FixedDepositScreen
import com.dev.chacha.savings.presentation.goal_savings.AboutGoalSavingsScreen
import com.dev.chacha.savings.presentation.goal_savings.GoalSavingsScreen
import com.dev.chacha.util.Graph.SAVINGS_SCREEN_ROUTE

fun NavGraphBuilder.savingsNavGraph(navController: NavHostController) {
    composable(route = SAVINGS_SCREEN_ROUTE ) {
        SavingsScreen(
            navController = navController
        )
    }
    composable(SavingsScreenNavigation.AboutCallDeposit.route){
        AboutCallDepositScreen()
    }

    composable(SavingsScreenNavigation.CallDeposit.route){
        CallDepositScreen()
    }
    composable(SavingsScreenNavigation.AboutClassicSavings.route){
        AboutClassicSavingsScreen()
    }

    composable(SavingsScreenNavigation.ClassicSavings.route){
        ClassicSavingsScreen()
    }

    composable(SavingsScreenNavigation.AboutFixedDeposit.route){
        AboutFixedDepositScreen()
    }

    composable(SavingsScreenNavigation.FixedDeposit.route){
        FixedDepositScreen()
    }

    composable(SavingsScreenNavigation.AboutGoalSavings.route){
        AboutGoalSavingsScreen()
    }
    composable(SavingsScreenNavigation.GoalSavings.route){
        GoalSavingsScreen()
    }



}


sealed class SavingsScreenNavigation(val route: String){
    object AboutCallDeposit: SavingsScreenNavigation(route= "about_call_Deposit")
    object CallDeposit: SavingsScreenNavigation( route = "call_Deposit")
    object AboutClassicSavings: SavingsScreenNavigation(route = "about_classic_savings")
    object ClassicSavings: SavingsScreenNavigation(route = "classic_savings")
    object AboutFixedDeposit: SavingsScreenNavigation(route = "about_fixed_deposit")
    object FixedDeposit: SavingsScreenNavigation(route = "fixed_deposit")
    object AboutGoalSavings: SavingsScreenNavigation(route = "about_goal_Savings")
    object GoalSavings: SavingsScreenNavigation(route = "goal_savings")
}