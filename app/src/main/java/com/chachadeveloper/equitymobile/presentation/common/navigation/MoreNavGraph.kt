package com.chachadeveloper.equitymobile.presentation.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dev.chacha.more.presentation.notification_screen.NotificationPreferences
import com.dev.chacha.more.presentation.notification_screen.NotificationScreen

fun NavGraphBuilder.moreScreenNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.MORE_DETAILS,
        startDestination = MoreScreen.NotificationScreen.route
    ) {
        composable(route = MoreScreen.NotificationScreen.route) {
            NotificationScreen() {
                navController.navigate(MoreScreen.NotificationPreferences.route)
            }
        }
        composable(route = MoreScreen.NotificationPreferences.route) {
            NotificationPreferences() {
                navController.popBackStack(
                    route = MoreScreen.NotificationScreen.route,
                    inclusive = false
                )
            }
        }
    }
}

sealed class MoreScreen(val route: String){
    object NotificationScreen: MoreScreen( route="notification")
    object ActivateChatBankingScreen: MoreScreen(route="activate_chat_banking")
    object SecurityScreen: MoreScreen(route="security")
    object SupportScreen: MoreScreen(route="support")
    object ChangeLanguageScreen: MoreScreen(route="change_language")
    object RecommendEquityMobileScreen: MoreScreen(route="reconsideration")
    object SignOutScreen: MoreScreen(route="sign-out")
    object NotificationPreferences: MoreScreen(route="sign-out")

}