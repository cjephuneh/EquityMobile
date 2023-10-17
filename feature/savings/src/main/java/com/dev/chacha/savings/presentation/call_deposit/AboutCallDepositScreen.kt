package com.dev.chacha.savings.presentation.call_deposit

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
fun AboutCallDepositScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Call deposit",
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
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = stringResource(id = R.string.about_call_deposit_title),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_call_deposit_desc),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_call_deposit_interest),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_call_deposit_information),
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = "Benefits",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_call_benefit),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.ideal_account_call),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.call_deposit_ideal_desc),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.what_you_need_call_deposit_title),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.what_you_need_call_deposit),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.call_deposit_top_and_withdraw_title),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.call_deposit_top_and_withdraw),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.call_deposit_account_closure),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.call_deposit_account_closure_desc),
                style = MaterialTheme.typography.titleSmall
            )
        }

    }
}