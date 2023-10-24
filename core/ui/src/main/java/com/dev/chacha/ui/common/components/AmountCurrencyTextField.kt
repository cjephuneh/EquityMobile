package com.dev.chacha.ui.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.ui.common.main_viewmodel.MainViewModel

@Composable
fun AmountCurrencyTextField(
    modifier: Modifier = Modifier,
    leftTextFieldValue: String = "",
    rightTextFieldValue: String = "",
    leftTextFieldPlaceholderHint: String = "",
    rightTextFieldPlaceholderHint: String,
    maxLines: Int = 1,
    onLeftValueChange: (String) -> Unit,
    onRightValueChange: (String) -> Unit,
    enabled: Boolean = true,
    leftTextFieldTitleHint: String = "currency",
    rightTextFieldTrailingIcon: ImageVector? = null,
    onClick: () -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Number,
    mainViewModel: MainViewModel = viewModel()
) {
    val uiState by mainViewModel.uiState.collectAsState()
    val textFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        focusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
    )
    val amountTextFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
    )
    Column(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = leftTextFieldTitleHint,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .56f),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BoxWithConstraints(
                modifier = modifier
                    .fillMaxWidth(0.35f)
                    .clipToBounds(),
            ) {
                TextField(
                    modifier = modifier
                        .fillMaxWidth()
                        .requiredWidth(maxWidth + 16.dp)
                        .offset(x = (-8).dp, y = (-3).dp),
                    value = leftTextFieldValue,
                    onValueChange = {
                        onLeftValueChange(it)
                    },
                    maxLines = maxLines,
                    placeholder = {
                        Text(
                            text = leftTextFieldPlaceholderHint,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .clickable {
                                    onLeftValueChange(leftTextFieldPlaceholderHint)
                                },
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.labelSmall


                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType
                    ),

                    colors = textFieldColors,
                    readOnly = true,
                    enabled = enabled,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = modifier.clickable(
                                MutableInteractionSource(),
                                null, onClickLabel = leftTextFieldPlaceholderHint
                            ) {
                                onLeftValueChange(leftTextFieldPlaceholderHint)
                            }
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            BoxWithConstraints(
                modifier = Modifier
                    .clipToBounds()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredWidth(maxWidth + 16.dp)
                        .offset(x = (-8).dp, y = (-3).dp),
                    value = rightTextFieldValue,
                    onValueChange = {
                        onRightValueChange(it)
                    },
                    maxLines = maxLines,
                    placeholder = {
                        Text(
                            text = rightTextFieldPlaceholderHint,
                            textAlign = TextAlign.Start,
                            modifier = modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .56f)

                        )
                    },
                    colors = amountTextFieldColors,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType
                    ),
                    readOnly = false,
                    trailingIcon = {
                        if (rightTextFieldTrailingIcon != null) {
                            Icon(
                                imageVector = rightTextFieldTrailingIcon,
                                contentDescription = null,
                                modifier = modifier
                                    .size(24.dp)
                                    .clickable(MutableInteractionSource(), null) {
                                        onClick()
                                    }
                            )
                        }
                    }
                )
            }

        }
    }

}

@Composable
@Preview
fun AmountCurrencyPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        AmountCurrencyTextField(
            leftTextFieldValue = "",
            rightTextFieldValue = "",
            leftTextFieldPlaceholderHint = "KSH",
            rightTextFieldPlaceholderHint = "Enter Amount",
            onLeftValueChange = {},
            onRightValueChange = {}
        )
    }

}


