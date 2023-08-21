package com.dev.chacha.ui.common.base

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RenderAdaptivePane(
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable () -> Unit,
) {
    Column {
        Box(
            Modifier
                .fillMaxSize(),
            contentAlignment = contentAlignment,
        ) {
            content()
        }
    }

}