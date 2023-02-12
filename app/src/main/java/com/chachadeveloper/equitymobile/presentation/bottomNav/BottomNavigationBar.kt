package com.chachadeveloper.equitymobile.presentation.bottomNav

import android.annotation.SuppressLint
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
import com.chachadeveloper.equitymobile.presentation.common.navigation.BottomBarScreen
import com.chachadeveloper.equitymobile.presentation.common.navigation.bottomNavigationItems
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.chachadeveloper.equitymobile.presentation.common.theme.primaryPink


@SuppressLint("RememberReturnType")
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar(
//        containerColor = Color.Transparent,
    ) {
        bottomNavigationItems.forEach { destination ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon),
                        contentDescription = destination.title,
                        modifier = Modifier.size(25.dp),
                    )
                },
                label = { Text(text = destination.title) },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(BottomBarScreen.Home.route) { inclusive = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = primaryPink,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    selectedTextColor = primaryPink,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground
                ),
            )
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