package com.chachadeveloper.equitymobile.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dev.chacha.auth.presentation.auth_screen.AuthScreen
import com.dev.chacha.auth.presentation.create_password_screen.CreatePasswordScreen
import com.dev.chacha.auth.presentation.forgot_password.ForgotPasswordScreen
import com.dev.chacha.auth.presentation.login_screen.LoginScreen
import com.dev.chacha.auth.presentation.login_screen.LoginViewModel
import com.dev.chacha.auth.presentation.register_screen.RegisterScreen
import com.dev.chacha.auth.presentation.register_screen.RegisterViewModel


fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Welcome.route
    ) {
        composable(AuthScreen.Welcome.route) {
            AuthScreen(
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
                    navController.navigate(Graph.HOME)

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
                    navController.navigate(Graph.HOME)
                },
                onLoginClick = {
                    navController.navigate(AuthScreen.Login.route)
                },
                viewModel = RegisterViewModel()
            )
        }
        composable(route = AuthScreen.CreatePassword.route) {
            CreatePasswordScreen(
                onClickAction = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }
            )
        }
        composable(route = AuthScreen.Forgot.route) {
            ForgotPasswordScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onLoginClick = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }
    }
}


sealed class AuthScreen(val route: String) {
    object Welcome : AuthScreen("welcome")
    object Login : AuthScreen(route = "LOGIN")
    object Register : AuthScreen(route = "REGISTER")
    object Forgot : AuthScreen(route = "FORGOT")
    object CreatePassword : AuthScreen(route = "CREATE_ACCOUNT")
}