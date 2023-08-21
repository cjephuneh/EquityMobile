package com.dev.chacha.ui.common.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R


@Composable
fun ConditionRow(
    condition: String,
    check: Boolean
) {
    val color by animateColorAsState(
        targetValue = if (check) Color.Green else MaterialTheme.colorScheme.onBackground,
        label = "text color"
    )

    val icon = if (check) {
        R.drawable._check_24
    } else {
        R.drawable.ic_circle_icon
    }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ){
        Icon(
            painter = painterResource(id = icon),
            tint = color,
            contentDescription = "status icon",
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = condition,
            color = color,
            style = MaterialTheme.typography.titleSmall
        )
    }
}