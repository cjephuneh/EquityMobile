package com.dev.chacha.ui.common.loading_indicator

import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ehsanmsz.mszprogressindicator.progressindicator.BallSpinFadeLoaderProgressIndicator
@androidx.compose.runtime.Composable
fun LoadingIndicator() {
    BallSpinFadeLoaderProgressIndicator(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.size(50.dp)
    )
}