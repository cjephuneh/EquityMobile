package com.dev.chacha.transaction.presentation.send_money

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun OwnEquityAccountScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Own Equity Account",
                showBackArrow = true,
                onNavigateBack = {}
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(24.dp)
                    .navigationBarsPadding()
            ) {
                EquityButton(
                    onClick = { /*TODO*/ },
                    text = "Send Money"
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Current Screen")
        }
    }

}