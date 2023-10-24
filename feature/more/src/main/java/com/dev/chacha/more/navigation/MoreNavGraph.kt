package com.dev.chacha.more.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.more.presentation.MoreScreen
import com.dev.chacha.more.presentation.change_language.ChangeLanguageScreen
import com.dev.chacha.more.presentation.get_touch.GetInTouchScreen
import com.dev.chacha.more.presentation.manage_devices_screen.ManageDeviceScreen
import com.dev.chacha.more.presentation.manage_devices_screen.MobileDevicesScreen
import com.dev.chacha.more.presentation.notification_preferences.BankAccountNotifications
import com.dev.chacha.more.presentation.security.SecurityScreen
import com.dev.chacha.more.presentation.notification_preferences.NotificationPreferences
import com.dev.chacha.more.presentation.notification_preferences.ReminderNotificationScreen
import com.dev.chacha.more.presentation.notification_preferences.TransactionAlertScreen
import com.dev.chacha.more.presentation.notification_screen.NotificationScreen
import com.dev.chacha.more.presentation.reset_password_screen.ResetPasswordScreen
import com.dev.chacha.more.presentation.reset_pin_screen.ResetPinScreen
import com.dev.chacha.more.presentation.support_scrren.SupportScreen
import com.dev.chacha.util.Graph.MORE_SCREEN_ROUTE

fun NavGraphBuilder.moreScreenNavGraph(navController: NavHostController) {
    composable(route = MORE_SCREEN_ROUTE) {
        MoreScreen(
            navigateToNotifications = { navController.navigate(MoreScreenNavigation.NotificationScreenNavigation.route) },
            navigateToSecurity = { navController.navigate(MoreScreenNavigation.SecurityScreenNavigation.route) },
            navigateToGetInTouch = { navController.navigate(MoreScreenNavigation.GetInTouch.route) },
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
        SecurityScreen(navController)
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
    composable(MoreScreenNavigation.ChangePassword.route){
        ResetPasswordScreen(navController)
    }
    composable(MoreScreenNavigation.ChangePin.route){
        ResetPinScreen(navController)
    }

    composable(MoreScreenNavigation.ManageSecurityQuestion.route){
       // SecurityScreen(navController)
    }

    composable(MoreScreenNavigation.ManageDevices.route){
       ManageDeviceScreen(navController)
    }

    composable(MoreScreenNavigation.MobileDevices.route){
        MobileDevicesScreen()
    }

    composable(MoreScreenNavigation.GetInTouch.route){
        GetInTouchScreen(navController)
    }

    composable(MoreScreenNavigation.BankAccountNotification.route){
        BankAccountNotifications(navController)
    }

    composable(MoreScreenNavigation.TransactionAlertNotification.route){
        TransactionAlertScreen(navController)
    }

    composable(MoreScreenNavigation.ReminderNotification.route){
        ReminderNotificationScreen(navController)
    }


}


sealed class MoreScreenNavigation(val route: String) {
    object NotificationScreenNavigation : MoreScreenNavigation(route = "notification")
    object ActivateChatBankingScreenNavigation : MoreScreenNavigation(route = "activate_chat_banking")

    object SecurityScreenNavigation : MoreScreenNavigation(route = "security")
    object SupportScreenNavigation : MoreScreenNavigation(route = "support")
    object ChangeLanguageScreenNavigation : MoreScreenNavigation(route = "change_language")
    object RecommendEquityMobileScreenNavigation : MoreScreenNavigation(route = "reconsideration")
    object SignOutScreenNavigation : MoreScreenNavigation(route = "sign-out")
    object NotificationPreferences : MoreScreenNavigation(route = "notification_preference-out")
    object ChangePassword : MoreScreenNavigation(route = "change_password")
    object ChangePin : MoreScreenNavigation(route = "change_pin-out")
    object ManageSecurityQuestion : MoreScreenNavigation(route = "manage_security_questions")
    object EnableTouchBiometric : MoreScreenNavigation(route = "biometric_enable")
    object ManageDevices : MoreScreenNavigation(route = "manage_devices")
    object MobileDevices : MoreScreenNavigation(route = "mobile_devices")
    object GetInTouch : MoreScreenNavigation(route = "get_in_touch")
    object BankAccountNotification : MoreScreenNavigation(route = "bank_alert")
    object ReminderNotification : MoreScreenNavigation(route = "reminders")
    object TransactionAlertNotification : MoreScreenNavigation(route = "trans_notification")



}