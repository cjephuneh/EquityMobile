package com.dev.chacha.home.presentation.home_screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.common.components.StandardToolbar


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
                    Divider()
                }
                item {
                    MyBalanceCard()
                }
                item {
                    CommonDots()
                }
                item {
                    MyAccountsCard()
                }
                item {
                    CommonDots()
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
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun HomeScreenPreview() {
    EquityMobileTheme {
        HomeScreen(
            navController = rememberNavController(),
            onClickAction = {}
        )
    }

}
