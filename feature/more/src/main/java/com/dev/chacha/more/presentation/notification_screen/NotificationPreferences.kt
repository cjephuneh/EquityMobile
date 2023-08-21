package com.dev.chacha.more.presentation.notification_screen

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.more.presentation.MoreScreenNavigation
import com.dev.chacha.more.presentation.component.MoreItemRow
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationPreferences(
    navigateBack: () -> Unit,
    navController: NavController
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                showBackArrow = true,
                title = "Notification Preference"
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
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    Text(
                        text = "Set your notification_screen preferences",
                        maxLines = 1,


                        )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = "Select which notifications you would like to receive",
                        maxLines = 1,
                    )

                    Box {
                        LazyColumn(){
                            items(notificationPreferenceOption) { accountItem ->
                                MoreItemRow(
                                    title = accountItem.title,
                                    drawable = accountItem.icon,
                                    onClick = { accountOptions ->
                                        when (accountOptions) {
                                            R.string.notifications_title -> {  }
                                            R.string.support_title -> { navController.navigate(MoreScreenNavigation.SupportScreenNavigation.route) }

                                        }
                                    },
                                )
                            }
                        }
                    }




                    Spacer(modifier = Modifier.height(15.dp))
                    MoreItemRow(
                        drawable = R.drawable.ic_support_foreground,
                        title = R.string.change_password_title,
                        subtitle = R.string.change_password_description,
                        onItemClick = {}
                    )

                    Spacer(modifier = Modifier.height(12.dp))


                    MoreItemRow(
                        drawable = R.drawable.ic_support_foreground,
                        title = R.string.change_password_title,
                        subtitle = R.string.change_password_description,
                        onItemClick = {}
                    )


                    Spacer(modifier = Modifier.height(12.dp))

                    MoreItemRow(
                        drawable = R.drawable.ic_support_foreground,
                        title = R.string.change_password_title,
                        subtitle = R.string.change_password_description,
                        onItemClick = {}
                    )

                    Spacer(modifier = Modifier.height(12.dp))


                    MoreItemRow(
                        drawable = R.drawable.ic_support_foreground,
                        title = R.string.change_password_title,
                        subtitle = R.string.change_password_description,
                        onItemClick = {}
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    MoreItemRow(
                        drawable = R.drawable.ic_support_foreground,
                        title = R.string.change_password_title,
                        subtitle = R.string.change_password_description,
                        onItemClick = {}
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                }
            }

        }

    }

}


data class NotificationPreferencesItem(
    @StringRes val title: Int,
    @StringRes val subtitle: Int? = null,
    @DrawableRes val icon: Int

)

private val notificationPreferenceOption = listOf(
    NotificationPreferencesItem(
        title = R.string.notifications_title,
        icon = R.drawable.ic_chevron_right
    ),
    NotificationPreferencesItem(
        title = R.string.support_title,
        subtitle = R.string.security_subtitle,
        icon = R.drawable.ic_chevron_right
    ),


)

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun NotificationPreferencesPreview() {
    EquityMobileTheme {
        NotificationPreferences(
            navigateBack = {},
            navController = rememberNavController()
        )
    }

}
