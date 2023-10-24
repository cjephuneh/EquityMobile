package com.dev.chacha.ui.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EquityButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enable: Boolean = false,
    showDivider: Boolean = true
) {
    Column (modifier = modifier){
        if (showDivider){
            EquityDivider()
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 20.dp
                )
        ) {
            Button(
                onClick = { onClick() },
                modifier = modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (enable) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                    contentColor = MaterialTheme.colorScheme.onBackground
                ),
                shape = RoundedCornerShape(8.dp),
                enabled = enable
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleSmall,
                    color = if (enable) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.background,
                    )
            }
        }

    }

}