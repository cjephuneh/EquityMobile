package com.dev.chacha.more.presentation.support_scrren

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.more.presentation.component.MoreItemRow
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar


@Composable
fun SupportScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Support",
                showBackArrow = true,
                showForwardArrow = true
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
                        .padding(start = 30.dp, end = 30.dp)
                ) {

                    Text(
                        text = "How can we help you?",
                        maxLines = 1,
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = stringResource(id = R.string.getInTouch),
                        maxLines = 2,
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    MoreItemRow(
                        drawable = R.drawable.ic_security_foreground,
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
                        drawable = R.drawable.ic_security_foreground,
                        title = R.string.change_password_title,
                        subtitle = R.string.change_password_description,
                        onItemClick = {}
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    MoreItemRow(
                        drawable = R.drawable.ic_fingerprint_foreground,
                        title = R.string.change_password_title,
                        subtitle = R.string.change_password_description,
                        onItemClick = {}
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    MoreItemRow(
                        drawable = R.drawable.devices,
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

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        SupportScreen()
    }

}
