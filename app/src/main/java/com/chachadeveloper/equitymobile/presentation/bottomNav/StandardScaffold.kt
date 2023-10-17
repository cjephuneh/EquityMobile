package com.chachadeveloper.equitymobile.presentation.bottomNav

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.theme.md_theme_light_primary
import com.dev.chacha.util.Graph.ACCOUNTS_SCREEN_ROUTE
import com.dev.chacha.util.Graph.HOME_SCREEN_ROUTE
import com.dev.chacha.util.Graph.MORE_SCREEN_ROUTE

@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = ACCOUNTS_SCREEN_ROUTE,
            icon = R.drawable.coin_stack,
            title = "Account",
            contentDescription = "Accounts"
        ),

        BottomNavItem(route = HOME_SCREEN_ROUTE),
        BottomNavItem(
            route = MORE_SCREEN_ROUTE,
            icon = R.drawable.outline_settings_24,
            title = "Settings",
            contentDescription = "Settings"
        ),
    ),
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = Color.White,
                    elevation = 16.dp
                ) {
                    BottomNavigation(
                        backgroundColor = Color.White
                    ) {
                        bottomNavItems.forEachIndexed { i, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                title = bottomNavItem.title,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                                alertCount = bottomNavItem.alertCount,
                                enabled = bottomNavItem.icon != null
                            ) {
                                if (navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                }
                            }
                        }

                    }
                }
            }
        },
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    modifier = Modifier
                        .offset(y = (24).dp),
                    backgroundColor = Color.White,
                    onClick = onFabClick,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 0.dp,
                        hoveredElevation = 0.dp
                    )
                ) {

                    Box (
                        modifier = Modifier
                            .padding(8.dp)
                            .size(64.dp)
                            .border(
                                2.dp,
                                if (navController.currentDestination?.route == HOME_SCREEN_ROUTE) {
                                    md_theme_light_primary
                                } else {
                                    Color.DarkGray
                                },
                                CircleShape

                            )
                        ,
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.equitybank_icon),
                            contentDescription = null,
                            colorFilter = if (navController.currentDestination?.route == HOME_SCREEN_ROUTE) {
                                null
                            } else {
                                ColorFilter.tint(Color.DarkGray)
                            },
                            modifier = Modifier
                                .size(28.dp)

                        )
                    }



                }


            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) { padding ->
        Column(Modifier.padding(padding)) {
            content()
        }
    }
}

data class BottomNavItem(
    val route: String,
    val icon: Int? = null,
    val title: String? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null,
)




