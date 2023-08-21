package com.dev.chacha.more.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.more.presentation.change_language.ChangeLanguageScreen
import com.dev.chacha.more.presentation.manage_security_qns_screen.ManageSecurityQnScreen
import com.dev.chacha.more.presentation.notification_screen.NotificationPreferences
import com.dev.chacha.more.presentation.notification_screen.NotificationScreen
import com.dev.chacha.more.presentation.support_scrren.SupportScreen
import com.dev.chacha.util.Graph.MORE_SCREEN_ROUTE

fun NavGraphBuilder.moreScreenNavGraph(navController: NavHostController) {
    composable(route = MORE_SCREEN_ROUTE) {
        MoreScreen(
            navigateToNotifications = { navController.navigate(MoreScreenNavigation.NotificationScreenNavigation.route) },
            navigateToSecurity = { navController.navigate(MoreScreenNavigation.SecurityScreenNavigation.route) },
            navigateToSupport = { navController.navigate(MoreScreenNavigation.SupportScreenNavigation.route) },
            navigateToChangeLanguage = { navController.navigate(MoreScreenNavigation.ChangeLanguageScreenNavigation.route) },
        ) { navController.navigate(MoreScreenNavigation.RecommendEquityMobileScreenNavigation.route) }
    }

    composable(route = MoreScreenNavigation.NotificationScreenNavigation.route) {
        NotificationScreen {
            navController.navigate(MoreScreenNavigation.NotificationPreferences.route)
        }
    }

    composable(MoreScreenNavigation.SupportScreenNavigation.route) {
        SupportScreen()
    }
    composable(MoreScreenNavigation.SecurityScreenNavigation.route) {
        ManageSecurityQnScreen()
    }

    composable(route = MoreScreenNavigation.ChangeLanguageScreenNavigation.route) {
        ChangeLanguageScreen()
    }

    composable(route = MoreScreenNavigation.NotificationPreferences.route) {
        NotificationPreferences(
            navigateBack = {
                navController.popBackStack(
                    route = MoreScreenNavigation.NotificationScreenNavigation.route,
                    inclusive = false
                )
            },
            navController = navController
        )
    }


}


sealed class MoreScreenNavigation(val route: String) {
    object NotificationScreenNavigation : MoreScreenNavigation(route = "notification")
    object ActivateChatBankingScreenNavigation :
        MoreScreenNavigation(route = "activate_chat_banking")

    object SecurityScreenNavigation : MoreScreenNavigation(route = "security")
    object SupportScreenNavigation : MoreScreenNavigation(route = "support")
    object ChangeLanguageScreenNavigation : MoreScreenNavigation(route = "change_language")
    object RecommendEquityMobileScreenNavigation : MoreScreenNavigation(route = "reconsideration")
    object SignOutScreenNavigation : MoreScreenNavigation(route = "sign-out")
    object NotificationPreferences : MoreScreenNavigation(route = "sign-out")

}