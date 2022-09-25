package com.chachadeveloper.equitymobile.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import com.chachadeveloper.equitymobile.presentation.NavGraphs
import com.chachadeveloper.equitymobile.presentation.components.StandardScaffold
import com.chachadeveloper.equitymobile.presentation.destinations.BorrowDestination
import com.chachadeveloper.equitymobile.presentation.destinations.HomeDestination
import com.chachadeveloper.equitymobile.presentation.destinations.MoreDestination
import com.chachadeveloper.equitymobile.presentation.destinations.TransactDestination
import com.chachadeveloper.equitymobile.ui.theme.EquityMobileTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EquityMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberAnimatedNavController()
                    val navHostEngine = rememberNavHostEngine()
                    val newBackStackEntry by navController.currentBackStackEntryAsState()
                    val route = newBackStackEntry?.destination?.route


                    StandardScaffold(
                        navController = navController,
                        showBottomBar = route in listOf(
                            HomeDestination.route,
                            TransactDestination.route,
                            BorrowDestination.route,
                            MoreDestination.route
                        )

                    ){ innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)){
                            DestinationsNavHost(
                                navGraph = NavGraphs.root,
                                navController = navController,
                                engine = navHostEngine
                            )
                        }

                    }
                }
            }
        }
    }
}

