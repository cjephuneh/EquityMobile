package com.chachadeveloper.equitymobile.core.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.chachadeveloper.equitymobile.NavGraphs
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.core.presentation.bottomNav.StandardScaffold
import com.chachadeveloper.equitymobile.core.presentation.common.theme.EquityMobileTheme
import com.chachadeveloper.equitymobile.destinations.BorrowScreenDestination
import com.chachadeveloper.equitymobile.destinations.HomeScreenDestination
import com.chachadeveloper.equitymobile.destinations.MoreScreenDestination
import com.chachadeveloper.equitymobile.destinations.TransactionScreenDestination
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine

class MainActivity : ComponentActivity()  {
    @OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EquityMobileTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    val navHostEngine = rememberNavHostEngine()
                    val newBackStackEntry by navController.currentBackStackEntryAsState()
                    val route = newBackStackEntry?.destination?.route

                    StandardScaffold(
                        navController = navController,
                        showBottomBar = route in listOf(
                            HomeScreenDestination.route,
                            TransactionScreenDestination.route,
                            BorrowScreenDestination.route,
                            MoreScreenDestination.route
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