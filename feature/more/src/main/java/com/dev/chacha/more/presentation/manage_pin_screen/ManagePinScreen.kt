package com.dev.chacha.more.presentation.manage_pin_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun ManagePinScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Mange your Pin",
                showForwardArrow = true,
                showBackArrow = true,
                onNavigateBack = {navController.navigateUp()}

            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {

            MoreVerticalItem(
                title = R.string.change_your_pin,
                drawable = R.drawable.ic_notifications_foreground,
                subtitle = R.string.change_your_existing_pin,
                onClick = {}
            )
            MoreVerticalItem(
                title = R.string.reset_your_pin,
                drawable = R.drawable.ic_notifications_foreground,
                subtitle = R.string.reset_your_pin_if_you_ve_forgotten_it,
                onClick = {}
            )


        }
    }


}

@Composable
fun ManagePinScreenPreview() {
    EquityMobileTheme {
        ManagePinScreen(
            rememberNavController()
        )
    }

}
