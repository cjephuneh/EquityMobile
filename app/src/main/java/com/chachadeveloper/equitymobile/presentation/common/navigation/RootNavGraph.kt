package com.chachadeveloper.equitymobile.presentation.common.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chachadeveloper.equitymobile.presentation.bottomNav.BottomNavigationBar


@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController)

        composable(route = Graph.HOME) {
            MainScreen()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { if (bottomBarState.value) BottomNavigationBar(navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {

            HomeNavGraph(
                navController = navController,
                showBottomBar = { bottomBarState.value = it },
            )

        }
    }
}

object Graph {
    const val HOME = "home_graph"
    const val AUTHENTICATION = "auth_graph"
    const val ROOT = "root_graph"
    const val DETAILS = "detail_route"
    const val MORE_DETAILS = "more_details"
    const val TRANSACTION_DETAILS = "transaction_details"
    const val BORROW_DETAILS = "borrow_details"
}