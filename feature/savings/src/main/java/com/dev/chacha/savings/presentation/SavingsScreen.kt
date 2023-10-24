package com.dev.chacha.savings.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dev.chacha.savings.navigation.SavingsScreenNavigation
import com.dev.chacha.savings.component.SavingsComponent
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun SavingsScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = stringResource(id = R.string.save),
                showForwardArrow = true
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
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                item {
                   Column(
                       verticalArrangement = Arrangement.spacedBy(12.dp),
                       modifier = Modifier.fillMaxWidth()
                   ) {
                       Text(
                           text = stringResource(id = R.string.savings_title),
                           style = MaterialTheme.typography.titleLarge
                       )
                       Text(
                           text = stringResource(id = R.string.savings_description),
                           fontSize = 12.sp,
                       )
                   }
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = R.string.classic_savings_title,
                        savingTypeSubtitle = R.string.classic_savings_subtitle,
                        onClickLearnMore = {navController.navigate(SavingsScreenNavigation.AboutClassicSavings.route)},
                        onClickOpenAccount = {navController.navigate(SavingsScreenNavigation.ClassicSavings.route)}
                    )
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = R.string.goal_savings_title,
                        savingTypeSubtitle = R.string.goal_savings_subtitle,
                        onClickLearnMore = {navController.navigate(SavingsScreenNavigation.AboutGoalSavings.route)},
                        onClickOpenAccount = {navController.navigate(SavingsScreenNavigation.GoalSavings.route)}
                    )
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = R.string.fixed_savings_title,
                        savingTypeSubtitle = R.string.fixed_savings_subtitle,
                        onClickLearnMore = {navController.navigate(SavingsScreenNavigation.AboutFixedDeposit.route)},
                        onClickOpenAccount = {navController.navigate(SavingsScreenNavigation.FixedDeposit.route)}
                    )
                }
                item {
                    SavingsComponent(
                        savingTypeTitle = R.string.call_savings_title,
                        savingTypeSubtitle = R.string.call_savings_subtitle,
                        onClickLearnMore = {navController.navigate(SavingsScreenNavigation.AboutCallDeposit.route)},
                        onClickOpenAccount = {navController.navigate(SavingsScreenNavigation.CallDeposit.route)}
                    )
                }
                item {
                    Box{}
                }
            }

        }

    }

}