package com.chachadeveloper.equitymobile.presentation.activity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chachadeveloper.equitymobile.presentation.bottomNav.BottomNavigationBar
import com.chachadeveloper.equitymobile.presentation.bottomNav.StandardScaffold
import com.dev.chacha.util.Graph.ACCOUNTS_SCREEN_ROUTE
import com.dev.chacha.util.Graph.HOME_SCREEN_ROUTE
import com.dev.chacha.util.Graph.MORE_SCREEN_ROUTE


/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            RootNavGraph(navController = navController,)
        }
    }
}


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // Create a variable to track whether the FAB should be shown
    var showFAB by remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Set showFAB to true for the initial screen, change this condition as needed

    Scaffold(
        modifier = Modifier,
        floatingActionButton = {
            Box {
                FloatingActionButton(
                    onClick = { showFAB = currentDestination?.route == HOME_SCREEN_ROUTE},
                    shape = CircleShape,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(80.dp)
                        .offset(y = 50.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = null,
                        modifier = Modifier.size(45.dp)
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                RootNavGraph(navController = navController)
            }
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    )

}

 */

