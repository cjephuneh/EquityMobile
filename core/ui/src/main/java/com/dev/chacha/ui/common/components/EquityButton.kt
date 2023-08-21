package com.dev.chacha.ui.common.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EquityButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enable: Boolean = false
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enable) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        shape = RoundedCornerShape(12),
        enabled = enable
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier.padding(8.dp)
        )
    }

}