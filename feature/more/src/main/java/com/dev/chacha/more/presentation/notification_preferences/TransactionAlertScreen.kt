package com.dev.chacha.more.presentation.notification_preferences

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityTextField
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun TransactionAlertScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Transaction alert",
                showBackArrow = true,
                onNavigateBack = {navController.navigateUp()}
            )
        }
    ) { paddingValues->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {
            Text(
                text = stringResource(R.string.select_the_account_you_want_to_get_transaction_alert_for),
                style = MaterialTheme.typography.titleLarge
            )

            EquityTextField(
                onValueChange = {},
                title = "Account",
                hint = "All accounts",
                showDefaultTrailingIcon = true
            )

            Text(
                text = stringResource(R.string.how_do_you_want_to_receive_your_alerts),
                style = MaterialTheme.typography.titleLarge
            )

            MoreVerticalItem(
                title = R.string.email_notification,
                drawable = R.drawable.mail_outline_24,
                subtitle = R.string.notification_disabled,
                showSwitcher = true
            )

            MoreVerticalItem(
                title = R.string.sms_alert,
                drawable = R.drawable.ic_question_answer_foreground,
                subtitle = R.string.alert_enabled,
                showSwitcher = true
            )


        }
    }

}