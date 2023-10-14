package com.dev.chacha.more.presentation


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dev.chacha.more.presentation.component.SignOutAlertDialog
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MoreScreen(
    navigateToNotifications: () -> Unit,
    navigateToSecurity: () -> Unit,
    navigateToGetInTouch: () -> Unit,
    navigateToChangeLanguage: () -> Unit,
    navigateToRecommendToFriend: () -> Unit
) {
    val moreViewModel: MoreViewModel = hiltViewModel()
    val moreUiState by moreViewModel.moreUiState.collectAsStateWithLifecycle()
    val shouldShowDialog = moreViewModel.shouldShowDialog.value

    if (shouldShowDialog) {
        SignOutAlertDialog(
            onDismissClick = { moreViewModel.setShowDialogState(!moreViewModel.shouldShowDialog.value) },
            onClick = {  }
        )
    }

    val userName = "Stephen Chacha"
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "More",
                showForwardArrow = true,
                showBackArrow = true
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 24.dp, end = 16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    MoreUserAccount()
                }
                item{
                    Box{}
                }
                item {
                    MoreVerticalItem(
                        drawable = R.drawable.outline_notifications_none_24,
                        title = R.string.notifications_title,
                        subtitle = R.string.notifications_subtitle,
                        onClick = {
                            navigateToNotifications()
                        }
                    )
                }
                item {
                    MoreVerticalItem(
                        drawable = R.drawable.outline_verified_user_24,
                        title = R.string.security_title,
                        subtitle = R.string.security_subtitle,
                        onClick = {
                            navigateToSecurity()
                        }
                    )
                }

                item {
                    MoreVerticalItem(
                        drawable = R.drawable.outline_headset_mic_24,
                        title = R.string.get_in_touch,
                        subtitle = R.string.get_in_touch_subtitle,
                        onClick = {
                            navigateToGetInTouch()
                        }
                    )
                }
                item {
                    MoreVerticalItem(
                        drawable = R.drawable.outline_language_24,
                        title = R.string.change_language_title,
                        onClick = {
                            navigateToChangeLanguage()
                        }
                    )
                }
                item {
                    MoreVerticalItem(
                        drawable = R.drawable.outline_phone_android,
                        title = R.string.recommend_equity_to_friend_title,
                        onClick = {}
                    )
                }

                item {
                    MoreVerticalItem(
                        drawable = R.drawable.outline_power_settings_new_24,
                        title = R.string.sign_out,
                        onClick = {
                            moreViewModel.setShowDialogState(true)
                        }
                    )
                }
                item {
                    Box(modifier = Modifier.fillMaxWidth()){
                        Text(
                            text = "Version 0.0.67",
                            color = Color.DarkGray,
                            fontSize = 12.sp
                        )
                    }

                }
            }
        }

    }

}
