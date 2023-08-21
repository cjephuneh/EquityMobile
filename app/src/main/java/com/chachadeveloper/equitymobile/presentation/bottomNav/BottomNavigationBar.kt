package com.chachadeveloper.equitymobile.presentation.bottomNav

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.util.Graph.BORROW_SCREEN_ROUTE
import com.dev.chacha.util.Graph.HOME_SCREEN_ROUTE
import com.dev.chacha.util.Graph.MORE_SCREEN_ROUTE
import com.dev.chacha.util.Graph.SAVINGS_SCREEN_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE


@SuppressLint("RememberReturnType")
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val isShowBottomBar = when (currentDestination?.route) {
        HOME_SCREEN_ROUTE, TRANSACTION_SCREEN_ROUTE,
        BORROW_SCREEN_ROUTE, SAVINGS_SCREEN_ROUTE, MORE_SCREEN_ROUTE, null -> true
        else -> false
    }

    if (isShowBottomBar) {
        NavigationBar(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            containerColor = MaterialTheme.colorScheme.background,
            tonalElevation = 0.dp
        ) {
            BottomBarDestination.values().asList().forEach { destination ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                    icon = {
                        Icon(
                            painter = painterResource(id = destination.icon),
                            contentDescription = destination.title,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text(text = destination.title) },
                    alwaysShowLabel = true,
                    onClick = {
                        navController.navigate(destination.route) {
                            popUpTo(HOME_SCREEN_ROUTE) { inclusive = false }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        indicatorColor = MaterialTheme.colorScheme.primary
                    ),
                )
            }
        }
    }

}


@Preview
@Composable
fun BottomNavigationPreview() {
    EquityMobileTheme {
        BottomNavigationBar(rememberNavController())
    }
}