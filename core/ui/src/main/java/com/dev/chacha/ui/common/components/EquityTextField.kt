package com.dev.chacha.ui.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun EquityTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    title: String = "",
    hint: String = "",
    maxLines: Int = 1,
    readOnly: Boolean = true,
    enabled: Boolean = true,
    showDefaultTrailingIcon: Boolean = false,
    otherTrailingIcons: ImageVector? = null
) {

    val textFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        focusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                MutableInteractionSource(),
                null, onClickLabel = value
            ) {
                onValueChange(value)
            },
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.labelSmall

        )

            BoxWithConstraints(
                modifier = Modifier
                    .height(52.dp)
                    .clipToBounds(),
                contentAlignment = Alignment.Center
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredWidth(maxWidth + 16.dp)
                        .offset(x = (-8).dp),
                    value = value,
                    onValueChange = {
                        onValueChange(it)
                    },
                    maxLines = maxLines,
                    placeholder = {
                        Text(
                            text = hint,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(MutableInteractionSource(), null, onClickLabel = hint) {
                                    onValueChange(hint)
                                },
                            style = MaterialTheme.typography.labelSmall

                        )
                    },

                    colors = textFieldColors,
                    readOnly = readOnly,
                    trailingIcon = {
                        if (showDefaultTrailingIcon){
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(
                                        MutableInteractionSource(),
                                        null, onClickLabel = hint
                                    ) {
                                        onValueChange(hint)
                                    }
                            )
                        }
                        if (otherTrailingIcons != null) {
                            Icon(
                                imageVector = otherTrailingIcons,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(
                                        MutableInteractionSource(),
                                        null, onClickLabel = hint
                                    ) { onValueChange(hint) },
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }


                    },
                    enabled = enabled

                )
            }
        }


}