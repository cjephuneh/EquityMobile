package com.dev.chacha.more.presentation.notification_screen

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryPink


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(
    navigateToNotificationPreferences: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        /* top bar*/
        StandardToolbar(
            title = "Notification",
            showForwardArrow = true,
            showBackArrow = true
        )
        Spacer(modifier = Modifier.height(5.dp))


        Column {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 25.dp, end = 25.dp)
                ) {


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                            .clickable {
                               navigateToNotificationPreferences()
                            }
                        ,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 10.dp)
                        ) {

                            Icon(
                                imageVector = Icons.Filled.Settings, contentDescription = null,
                                tint = primaryPink,
                                modifier = Modifier.size(60.dp)
                            )

                            Column(modifier = Modifier.padding(start = 10.dp)) {
                                Text(
                                    text = "Notification Preferences",
                                    maxLines = 1,
                                    fontSize = 13.sp,
                                    modifier = Modifier.clickable {
                                    },
                                )

                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                painter = painterResource(id = R.drawable.ic_chevron_right),
                                tint = primaryPink,
                                contentDescription = null,

                                )


                        }

                    }

                }
            }
        }

    }
}

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun NotificationScreenPreview() {
    EquityMobileTheme {
        NotificationScreen {
        }
    }

}