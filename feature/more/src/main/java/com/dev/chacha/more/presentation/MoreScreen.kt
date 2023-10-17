package com.dev.chacha.more.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dev.chacha.more.presentation.component.SignOutAlertDialog
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.MoreVerticalItemWithCard
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.DefaultBackground

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
    val uriHandler = LocalUriHandler.current


    val userName = "Stephen Chacha"
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Settings and more",
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = DefaultBackground
                ),
                showTitleWithUsername = true,
                userName = "Stephen Chacha"
            )
        },
        containerColor = DefaultBackground
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DefaultBackground)
                .padding(paddingValues)
                .padding(start = 24.dp, end = 16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        MoreUserAccount()
                        MoreVerticalItemWithCard(
                            drawable = R.drawable.outline_notifications_none_24,
                            title = R.string.notifications_title,
                            subtitle = R.string.notifications_subtitle,
                            onClick = {
                                navigateToNotifications()
                            }
                        )
                        MoreVerticalItemWithCard(
                            drawable = R.drawable.outline_language_24,
                            title = R.string.change_language_title,
                            onClick = {
                                navigateToChangeLanguage()
                            }
                        )
                    }

                }
                item {
                    Text(
                        text = "Support",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        MoreVerticalItemWithCard(
                            drawable = R.drawable.whatsapp,
                            title = R.string.activate_chat_banking,
                            subtitle = R.string.activate_chat_banking_desc,
                            onClick = {
                                uriHandler.openUri("https://equitygroupholdings.com/ke")

                            },
                            showColorFilter = true
                        )
                        MoreVerticalItemWithCard(
                            drawable = R.drawable.outline_headset_mic_24,
                            title = R.string.get_in_touch,
                            subtitle = R.string.get_in_touch_subtitle,
                            onClick = {
                                navigateToGetInTouch()
                            }
                        )


                    }

                }

                item {
                    Text(
                        text = "Security",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                item {
                    MoreVerticalItemWithCard(
                        drawable = R.drawable.outline_verified_user_24,
                        title = R.string.security_title,
                        subtitle = R.string.security_subtitle,
                        onClick = {
                            navigateToSecurity()
                        }
                    )
                }

                item {
                    Text(
                        text = "About us",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                item {
                    MoreVerticalItemWithCard(
                        drawable = R.drawable.outline_phone_android,
                        title = R.string.recommed,
                        subtitle = R.string.recommend_equity_to_friend_title,
                        onClick = {}
                    )
                }

                item{
                    Box{}
                }

            }
        }

    }

}
