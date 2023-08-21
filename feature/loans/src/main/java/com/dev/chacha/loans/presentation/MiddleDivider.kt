package com.dev.chacha.loans.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MiddleDivider() {
    Divider(
        thickness = 1.dp,
        modifier = Modifier
            .padding(
                start = 65.dp,
                end = 8.dp,
                bottom = 12.dp,
                top = 12.dp
            )
    )
}