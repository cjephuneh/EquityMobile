package com.dev.chacha.more.presentation.notification_preferences

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.more.navigation.MoreScreenNavigation
import com.dev.chacha.more.presentation.MoreUiEvent
import com.dev.chacha.more.presentation.MoreViewModel
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationPreferences(
    navigateBack: () -> Unit,
    navController: NavController
) {

    val moreViewModel: MoreViewModel = hiltViewModel()
    val moreUiState by moreViewModel.moreUiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            StandardToolbar(
                showBackArrow = true,
                title = "Notification Preference",
                onNavigateBack = navigateBack
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                contentAlignment = Alignment.TopStart
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(
                                text = "Set your notification screen preferences",
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = "Select which notifications you would like to receive",
                            )
                        }
                    }

                    items(notificationPreferenceOption) { accountItem ->
                        MoreVerticalItem(
                            title = accountItem.title,
                            subtitle = accountItem.subtitle,
                            statusNotification = accountItem.statusNotification,
                            showSwitcher = accountItem.showSwitcher,
                            onClick = { accountOptions ->
                                when (accountOptions) {
                                    R.string.transaction_alert -> {
                                        navController.navigate(MoreScreenNavigation.TransactionAlertNotification.route)
                                    }

                                    R.string.reminders -> {
                                        navController.navigate(MoreScreenNavigation.ReminderNotification.route)
                                    }

                                    R.string.bank_account_alert -> {
                                        navController.navigate(MoreScreenNavigation.BankAccountNotification.route)
                                    }

                                    R.string.service_update -> {

                                    }
                                    R.string.marketing_content -> {
                                        if (moreUiState.isMarketContentEnabled){
                                            moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(true))
                                        } else{
                                            moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(false))
                                        }
                                    }
                                    R.string.events -> {
//                                        moreViewModel.onEvent(MoreUiEvent.EnableEventToggled(true))

                                    }

                                }
                            },
                            isChecked = moreUiState.isMarketContentEnabled,
                            onCheckChange = {isEnabled->
                                if (moreUiState.isMarketContentEnabled){
                                    moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(isEnabled))
                                } else{
                                    moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(isEnabled))
                                }
                            }
                        )
                    }
                    item {
                        MoreVerticalItem(
                            title = R.string.service_update,
                            showSwitcher = true,
                            isChecked = moreUiState.isMarketContentEnabled,
                            onCheckChange = {isEnabled->
                                if (!moreUiState.isMarketContentEnabled){
                                    moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(isEnabled))

                                } else{
                                    moreViewModel.onEvent(MoreUiEvent.EnableMarketContentToggled(isEnabled))
                                }
                            }
                        )
                    }

                }
            }

        }
    }


}


data class NotificationPreferencesItem(
    @StringRes val title: Int,
    @StringRes val subtitle: Int? = null,
    @DrawableRes val icon: Int? = null,
    val onCheckChange: (Boolean) -> Unit = {},
    val isChecked: () -> Boolean = { false },
    val showSwitcher: Boolean = false,
    val statusNotification: Boolean = false

)

private val notificationPreferenceOption = listOf(
    NotificationPreferencesItem(
        title = R.string.transaction_alert,
        subtitle = R.string.transaction_alert_desc,
        statusNotification = true
    ),
    NotificationPreferencesItem(
        title = R.string.reminders,
        subtitle = R.string.reminder_desc,
        statusNotification = true
    ),
    NotificationPreferencesItem(
        title = R.string.bank_account_alert,
        subtitle = R.string.bank_account_alert_desc,
        statusNotification = true
    ),
    NotificationPreferencesItem(
        title = R.string.service_update,
        subtitle = R.string.service_update_desc,
        showSwitcher = true
    ),
    NotificationPreferencesItem(
        title = R.string.marketing_content,
        subtitle = R.string.marketing_content_desc,
        showSwitcher = true
    ),

    NotificationPreferencesItem(
        title = R.string.events,
        subtitle = R.string.events_desc,
        showSwitcher = true
    ),

    )

@Composable
fun NotificationPreferencesPreview() {
    EquityMobileTheme {
        NotificationPreferences(
            navigateBack = {},
            navController = rememberNavController()
        )
    }

}
