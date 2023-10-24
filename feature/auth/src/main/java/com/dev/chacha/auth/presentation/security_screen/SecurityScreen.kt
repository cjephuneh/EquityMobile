package com.dev.chacha.auth.presentation.security_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecurityScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                showBackArrow = true,
                title = "Security Questions"
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {

            SecurityItemRow(
                drawable = R.drawable.ic_support_foreground,
                title = R.string.change_password_title,
                subtitle = R.string.change_password_description,
                onItemClick = {}
            )

            SecurityItemRow(
                drawable = R.drawable.ic_support_foreground,
                title = R.string.change_password_title,
                subtitle = R.string.change_password_description,
                onItemClick = {}
            )

            SecurityItemRow(
                drawable = R.drawable.ic_support_foreground,
                title = R.string.change_password_title,
                subtitle = R.string.change_password_description,
                onItemClick = {}
            )

            SecurityItemRow(
                drawable = R.drawable.ic_support_foreground,
                title = R.string.change_password_title,
                subtitle = R.string.change_password_description,
                onItemClick = {}
            )

            SecurityItemRow(
                drawable = R.drawable.ic_support_foreground,
                title = R.string.change_password_title,
                subtitle = R.string.change_password_description,
                onItemClick = {}
            )
        }


    }

}

@Composable
fun SecurityScreenPreview() {
    EquityMobileTheme {
        SecurityScreen()
    }

}





