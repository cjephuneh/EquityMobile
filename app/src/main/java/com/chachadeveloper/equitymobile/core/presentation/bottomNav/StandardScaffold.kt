package com.chachadeveloper.equitymobile.core.presentation.bottomNav

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryGray
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardScaffold(
    navController: NavController,
    showBottomBar: Boolean = true,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.Transact,
        BottomNavItem.Borrow,
        BottomNavItem.More
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit,
) {

    Scaffold(

        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    contentColor = Color.White,
                    tonalElevation = 5.dp
                ) {

                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    items.forEach { item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    painter = painterResource(id=item.icon),
                                    contentDescription = item.title,
                                    modifier = Modifier.size(25.dp)
                                )

                            },
                            label = {
                                    Text(
                                        text = item.title,
                                        fontSize = 9.sp,
                                        modifier = Modifier.clip(CircleShape)
                                    )

                            },
                            alwaysShowLabel = true,
                            selected = currentDestination?.route?.contains(item.destination.route) == true,
                            onClick = {
                                navController.navigate(item.destination.route) {
                                    navController.graph.startDestinationRoute?.let { screen_route ->
                                        popUpTo(screen_route) {
                                            saveState = true
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }

}
