package com.dev.chacha.transaction.presentation.transaction

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MiddleDivider() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(16.dp))
        Divider(
            thickness = 1.dp,
            modifier = Modifier.padding(start = 60.dp, end = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
    }

}