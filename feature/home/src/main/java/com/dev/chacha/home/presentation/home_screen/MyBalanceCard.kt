package com.dev.chacha.home.presentation.home_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardCard

@Composable
fun MyBalanceCard() {
    var expanded by remember { mutableStateOf(false) }
    val icons = if (expanded) Icons.Default.VisibilityOff else Icons.Default.Visibility
    val text = if (expanded) "Hide Balance" else "Show Balance"

    val extraPaddingValues by animateDpAsState(
        if (expanded) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = ""
    )

    StandardCard(
        modifier = Modifier
            .fillMaxWidth().padding(horizontal = 16.dp)
            .clickable(MutableInteractionSource(), null) {
                expanded = !expanded
            }
            .wrapContentHeight(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.my_balance),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = text,
                    modifier = Modifier
                        .clickable(MutableInteractionSource(), null) {
                            expanded = !expanded
                        },
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleSmall


                )
                Icon(
                    imageVector = icons,
                    contentDescription = text,
                    modifier = Modifier
                        .clickable(MutableInteractionSource(), null) {
                            expanded = !expanded
                        },
                    tint = MaterialTheme.colorScheme.primary

                )
            }

            AnimatedVisibility(visible = expanded) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "KES",
                        color = MaterialTheme.colorScheme.primary

                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(100.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Text(text = stringResource(id = R.string.you_have_hint))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowUpward,
                                    contentDescription = "Arrow up",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                                Text(text = "80.56")
                            }
                        }

                        Column {
                            Text(text = stringResource(id = R.string.yow_owe_hint))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDownward,
                                    contentDescription = "Arrow Down",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                                Text(text = "0.00")
                            }
                        }
                    }
                }
            }
        }
    }
}
