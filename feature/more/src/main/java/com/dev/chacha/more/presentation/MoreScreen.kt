package com.dev.chacha.more.presentation


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.extensions.getInitials
import com.dev.chacha.more.presentation.component.MoreItemRow
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MoreScreen(
    navigateToNotifications: () -> Unit,
    navigateToSecurity: () -> Unit,
    navigateToSupport: () -> Unit,
    navigateToChangeLanguage: () -> Unit,
    navigateToRecommendToFriend: () -> Unit
) {
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
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    1.dp,
                                    Color.LightGray,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .height(100.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,

                                ) {
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .background( MaterialTheme.colorScheme.outline),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = getInitials(userName),
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center,
                                        fontSize = 28.sp
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 10.dp, end = 10.dp)
                                ) {
                                    Text(
                                        text = userName,
                                        maxLines = 1,
                                    )
                                    Spacer(modifier = Modifier.height(1.dp))
                                    Text(
                                        text = "stevechacha4@gmail.com",
                                        maxLines = 1,
                                    )
                                    Spacer(modifier = Modifier.height(1.dp))
                                    Text(
                                        text = "254746656813",
                                        maxLines = 1,
                                    )
                                }

                            }

                        }
                }
                item{
                    Box{}
                }
                item {
                    MoreItemRow(
                        drawable = R.drawable.ic_support_foreground,
                        title = R.string.notifications_title,
                        subtitle = R.string.notifications_subtitle,
                        onClick = {
                            navigateToNotifications()
                        }
                    )
                }
                item {
                    MoreItemRow(
                        drawable = R.drawable.ic_notifications_foreground,
                        title = R.string.security_title,
                        subtitle = R.string.security_subtitle,
                        onClick = {
                            navigateToSecurity()
                        }
                    )
                }

                item {
                    MoreItemRow(
                        drawable = R.drawable.ic_support_foreground,
                        title = R.string.support_title,
                        subtitle = R.string.security_subtitle,
                        onClick = {
                            navigateToSupport()
                        }
                    )
                }
                item {
                    MoreItemRow(
                        drawable = R.drawable.ic_support_foreground,
                        title = R.string.change_language_title,
                        onClick = {
                            navigateToChangeLanguage()
                        }
                    )
                }
                item {
                    MoreItemRow(
                        drawable = R.drawable.ic_support_foreground,
                        title = R.string.recommend_equity_to_friend_title,
                        onClick = {}
                    )
                }

                item {
                    MoreItemRow(
                        drawable = R.drawable.ic_signout_foreground,
                        title = R.string.sign_out,
                        onClick = {}
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

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun MoreScreenPreview() {
    EquityMobileTheme {
        MoreScreen(
            navigateToNotifications = {/*TODO*/  },
            navigateToSecurity = { /*TODO*/ },
            navigateToSupport = { /*TODO*/ },
            navigateToChangeLanguage = { /*TODO*/ },
            navigateToRecommendToFriend = {}
        )
    }

}
