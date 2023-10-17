package com.dev.chacha.savings.presentation.goal_savings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.EquityOutlinedButton
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.components.TwoButtonsVertical

@Composable
@Preview
fun AboutGoalSavingsScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Goal Savings",
                showBackArrow = true
            )
        },
        bottomBar = {
            TwoButtonsVertical(
                topButtonText = stringResource(id = R.string.view_term_and_condition),
                bottomButtonText = stringResource(id = R.string.open_an_account),
                onTopButtonClick = { /*TODO*/ },
                onBottomButtonClick = { /*TODO*/ },
                showTopButton = true
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.about_goal_savings_title),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_goal_account),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.goal_interest_title),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_goal_interest_rate),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_goal_account_benefit),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_goal_account_benefit_1),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_goal_account_ideal),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_goal_account_ideal_desc),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_goal_account_what_you_need),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_goal_account_what_you_need_description),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_goal_account_top_up_and_withdraw),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_goal_account_top_up_and_withdraw_desc),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_goal_account_account_closure),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_goal_account_account_closure_desc),
                style = MaterialTheme.typography.titleSmall
            )
        }
    }


}