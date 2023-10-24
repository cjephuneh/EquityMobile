package com.dev.chacha.more.presentation.manage_devices_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun MobileDevicesScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Mobile devices",
                showBackArrow = true,

                )
        }) { paddingValues ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = stringResource(R.string.which_device_would_you_like_to_remove),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(id = R.string.mobile_devices_desc),
            )
        }


    }
}