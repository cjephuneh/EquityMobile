package com.dev.chacha.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AlertNotification(
    modifier: Modifier = Modifier,
    alertCount: Int? = null,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(64.dp)
            .padding(8.dp)

    ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        MaterialTheme.colorScheme.outline,
                        CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

        if (alertCount != null) {
            val alertText = if (alertCount > 9) {
                "9+"
            } else {
                alertCount.toString()
            }
            Text(
                text = alertText,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = 10.dp, y = (-5).dp)
                    .width(20.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
    }
}

@Composable
@Preview
fun BadgeBoxxx(
    badgeCount: Int = 100
) {
    Box(
        modifier = Modifier.size(100.dp),
        contentAlignment = Alignment.Center
    ) {
        BadgedBox(
            badge = {
                Badge(
                    containerColor = if (badgeCount > 0) MaterialTheme.colorScheme.primary else Color.Transparent
                ) {

                    val badgeNumber = if (badgeCount > 200) {
                        "9+"
                    } else {
                        badgeCount.toString()
                    }
                    Text(
                        text = if (badgeCount > 0) badgeNumber else "",
                        modifier = Modifier.semantics {
                            contentDescription = "$badgeNumber new notifications"
                        }
                    )
                }

            },
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        MaterialTheme.colorScheme.primary,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = "Favorite",

                    )
            }

        }
    }

}

@Composable
fun BadgePreview() {
    BadgeBoxxx(
        badgeCount = 10
    )
}


@Composable
@Preview
fun AlertNotificationPreview() {
    AlertNotification(
        onClick = {},
        alertCount = 100
    )
}

