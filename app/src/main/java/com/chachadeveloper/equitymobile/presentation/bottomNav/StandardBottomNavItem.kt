package com.chachadeveloper.equitymobile.presentation.bottomNav

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.common.theme.md_theme_light_primary
import androidx.compose.material3.Icon
import androidx.compose.material3.Text


@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    icon: Int? = null,
    title: String? = null,
    contentDescription: String? = null,
    selected: Boolean = false,
    alertCount: Int? = null,
    selectedColor: Color = md_theme_light_primary,
    unselectedColor: Color = Color(0xFF8B8B8B),
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    if (alertCount != null && alertCount < 0) {
        throw IllegalArgumentException("Alert count can't be negative")
    }
    val lineLength = animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

    BottomNavigationItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedColor,
        unselectedContentColor = unselectedColor,
        icon = {
            if (icon != null) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = contentDescription,
                    modifier = Modifier.size(25.dp),
                    tint = if (selected) selectedColor else unselectedColor,

                    )
            }
        },
        label = {
            if (title != null) {
               Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    fontSize = 11.sp,
                    color = if (selected) selectedColor else unselectedColor,

                    )
            }
        },
        alwaysShowLabel = true
    )
}