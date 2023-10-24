package com.dev.chacha.auth.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dev.chacha.auth.presentation.auth_screen.WelcomeScreen
import com.dev.chacha.auth.presentation.biometric.BiometricSetUpScreen
import com.dev.chacha.auth.presentation.code_verification.SmsVerificationScreen
import com.dev.chacha.auth.presentation.create_password.CreatePasswordScreen
import com.dev.chacha.auth.presentation.forgot_password.ForgotPasswordScreen
import com.dev.chacha.auth.presentation.login.LoginScreen
import com.dev.chacha.auth.presentation.login.LoginViewModel
import com.dev.chacha.auth.presentation.main_login.MainLoginScreen
import com.dev.chacha.auth.presentation.register.PrivacyPolicy
import com.dev.chacha.auth.presentation.register.RegisterScreen
import com.dev.chacha.auth.presentation.register.TermsAndConditionScreen
import com.dev.chacha.auth.presentation.verification_options.ChooseVerificationScreen
import com.dev.chacha.util.Graph


@RequiresApi(Build.VERSION_CODES.P)
fun NavGraphBuilder.authNavGraph(navController: NavHostController) {

    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Welcome.route
    ) {
        composable(AuthScreen.Welcome.route) {
            WelcomeScreen(
                onSignUp = {
                    navController.navigate(AuthScreen.Register.route)
                },
                onLogin = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }
        composable(route = AuthScreen.Login.route) {
            LoginScreen(
                onNavigateToHome = {
                    navController.popBackStack()
                    navController.navigate(AuthScreen.CodeVerification.route)

                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.Register.route)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot.route)
                },
                viewModel = LoginViewModel()
            )
        }
        composable(route = AuthScreen.Register.route) {
            RegisterScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME_SCREEN_ROUTE)
                },
                onLoginClick = {
                    navController.navigate(AuthScreen.Login.route)
                },
                navController = navController
            )
        }
        composable(route = AuthScreen.CreatePassword.route) {
            CreatePasswordScreen(
                onClickAction = {
                    navController.popBackStack()
                    navController.navigate(AuthScreen.CodeVerification.route)
                }
            )
        }
        composable(route = AuthScreen.Forgot.route) {
            ForgotPasswordScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME_SCREEN_ROUTE)
                },
                onLoginClick = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }
        composable(AuthScreen.PrivacyTerms.route){
            PrivacyPolicy()
        }

        composable(AuthScreen.TermsCondition.route){
            TermsAndConditionScreen()
        }
        composable(AuthScreen.CodeVerification.route){
            ChooseVerificationScreen(navController)
        }
        composable(AuthScreen.SmsCodeVerification.route){
            SmsVerificationScreen(navController)
        }
        composable(AuthScreen.BiometricSetUp.route){
            BiometricSetUpScreen(navController)
        }

        composable(AuthScreen.MainLogin.route){
            MainLoginScreen(navController)
        }
    }
}


sealed class AuthScreen(val route: String) {

    object MainLogin: AuthScreen("main_login")

    object Welcome : AuthScreen("welcome")
    object Login : AuthScreen(route = "LOGIN")
    object BiometricSetUp : AuthScreen(route = "biometric")
    object CodeVerification : AuthScreen("code")
    object SmsCodeVerification : AuthScreen("sms")
    object Register : AuthScreen(route = "REGISTER")
    object Forgot : AuthScreen(route = "FORGOT")
    object CreatePassword : AuthScreen(route = "CREATE_ACCOUNT")
    object TermsCondition : AuthScreen(route = "terms")
    object PrivacyTerms : AuthScreen(route = "privacy policy")

}