package com.dev.chacha.savings.presentation.classic_savings

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
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.EquityOutlinedButton
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.components.TwoButtonsVertical

@Composable
fun AboutClassicSavingsScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Classic savings",
                showBackArrow = true
            )
        },
        bottomBar = {
            TwoButtonsVertical(
                topButtonText = stringResource(id = R.string.view_term_and_condition),
                bottomButtonText = stringResource(id = R.string.open_an_account),
                onTopButtonClick = { /*TODO*/ },
                onBottomButtonClick = { /*TODO*/ }
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
                text = stringResource(id = R.string.about_classic_savings_title),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_classic_account),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_classic_interest_title),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_classic_interest_rate_desc_1),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_classic_account_rate_desc_2),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_classic_interest_information),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.what_should_you_get_account),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.what_should_you_get_classic_account_desc),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_classic_bonus),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.what_you_need_classic_account),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.what_you_need_classic_account_desc),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_classic_withdrawals),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_classic_withdraw_desc_1),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_classic_account_withdraw_3),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_classic_account_withdraw_4),
                style = MaterialTheme.typography.titleSmall
            )
        }
    }


}