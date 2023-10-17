package com.dev.chacha.savings.presentation.fixed_deposit

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
fun AboutFixedDepositScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Fixed deposit",
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
                text = stringResource(id = R.string.about_fixed_account),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_fixed_account_desc),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_fixed_deposit_interest),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_fixed_deposit_desc),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_fixed_deposit_information),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.about_fixed_should_you_account),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_fixed_should_you_this_account_desc),
                style = MaterialTheme.typography.titleSmall,

            )
            Text(
                text = stringResource(id = R.string.about_what_do_need_to_open_hint),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.about_what_do_need_to_open_desc),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Withdrawal",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(id = R.string.fixed_withdrawal),
                style = MaterialTheme.typography.titleSmall
            )
        }
    }

}