package com.dev.chacha.ui.common.default_indicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SecondPageIndicator() {
    HorizontalIndicator(pageCount = 3)
}

@Composable
private fun HorizontalIndicator(pageCount: Int = 3) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        repeat(pageCount) { pageIndex ->
            val indicatorColor = if (pageIndex <= 1) {
                MaterialTheme.colorScheme.onBackground
            } else {
               Color.LightGray
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(4.dp)
                    .padding(horizontal = 4.dp)
                    .background(
                        color = indicatorColor,
                        shape = RoundedCornerShape(6.dp)
                    )
            )
        }
    }
}
