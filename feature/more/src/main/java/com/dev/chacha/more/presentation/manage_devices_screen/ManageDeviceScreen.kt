package com.dev.chacha.more.presentation.manage_devices_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.more.presentation.MoreScreenNavigation
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.device_info.getDeviceInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageDeviceScreen(
    navController: NavController
) {
    val deviceInfo = getDeviceInfo()
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Manage your devices",
                showBackArrow = true,
                onNavigateBack = {
                    navController.navigateUp()
                }

            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = "Select the devices you want to manage",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = stringResource(id = R.string.manage_devices),
                )

                Spacer(modifier = Modifier.height(15.dp))
                MoreVerticalItem(
                    drawable = R.drawable.outline_phone_android,
                    title = R.string.mobile_device,
                    subtitle = R.string.manage_devices,
                    onClick = {
                        navController.navigate(MoreScreenNavigation.MobileDevices.route)
                    }
                )


                MoreVerticalItem(
                    drawable = R.drawable.outline_desktop_windows_24,
                    title = R.string.web_devices,
                    subtitle = R.string.web_devices_no,
                    onClick = {}
                )


            }

        }

    }


}


@Composable
fun ManageDeviceScreenPreview() {
    EquityMobileTheme {
        ManageDeviceScreen(navController = rememberNavController())
    }

}
