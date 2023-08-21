package com.dev.chacha.more.presentation.manage_devices_screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageDeviceScreen() {
    Scaffold(
        topBar = {
        StandardToolbar(
            title = "Manage Devices",
            showForwardArrow = true,

            )
    }) { paddingValues ->
        Column(
            modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp)
                ) {

                    Text(
                        text = "Select the devices you want to manage",
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = stringResource(id = R.string.manage_devices),
                        maxLines = 2,
                    )

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


                }


            }

        }
        
    }



}

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun ManageDeviceScreenPreview() {
    EquityMobileTheme {
        ManageDeviceScreen()
    }

}
