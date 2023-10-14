package com.dev.chacha.home.presentation.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.home.presentation.home_screen.components.HomeServiceCard
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.util.Graph.ANOTHER_BANK_ROUTE
import com.dev.chacha.util.Graph.BORROW_SCREEN_ROUTE
import com.dev.chacha.util.Graph.SAVINGS_SCREEN_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE


@Composable
fun HomeScreen(
    onClickAction : ()-> Unit,
    navController: NavController
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Home",
                showForwardArrow = true,
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {


            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                item{
                    HomeGreetings()
                }
                item {
                    OnBoardingHome(navController = navController)
                }

                item {
                    HomeServiceCard(
                        onClickBorrow = {navController.navigate(BORROW_SCREEN_ROUTE)},
                        onClickSave = {navController.navigate(SAVINGS_SCREEN_ROUTE)},
                        onClickTransact = {navController.navigate(TRANSACTION_SCREEN_ROUTE)}
                    )
                }

                item {
                    MyBalanceCard()
                }

                item {
                    MyAccountsCard(navController)
                }

                item {
                    AddAccountCard()
                }
                item { 
                    MyPayPalAccounts()
                }
                item {
                    CreatePayPalAccount()
                }
                item{
                    Box{}
                }

            }

        }

    }

}


@Composable
fun HomeScreenPreview() {
    EquityMobileTheme {
        HomeScreen(
            navController = rememberNavController(),
            onClickAction = {}
        )
    }

}
