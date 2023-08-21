package com.dev.chacha.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.theme.Transparent
import com.dev.chacha.ui.common.theme.primaryPink

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    title: String = "",
    text: String = "",
    hint: String = "",
    maxLength: Int = 50,
    error: String = "",
    singleLine: Boolean = true,
    maxLines: Int = 1,
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit,
    focusRequester: FocusRequester = FocusRequester()
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val indicatorUnfocusedWidth = 1.dp
    val indicatorFocusedWidth = 2.dp
    val textFieldPadding = 17.dp
    val color = Color.White.copy(alpha = 0.78F)
    val textFieldColors = TextFieldDefaults.textFieldColors(
        focusedLabelColor = Transparent,
        unfocusedLabelColor = color,
        containerColor = MaterialTheme.colorScheme.background

    )

    val indicatorColor = if (isFocused) primaryPink else Color.DarkGray
    val indicatorWidth = if (isFocused) indicatorFocusedWidth else indicatorUnfocusedWidth

    Column(
        modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 4.dp, end = 4.dp),
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            maxLines = maxLines,
            placeholder = {
                Text(
                    text = hint,
                    textAlign = TextAlign.Start,
                    color = Color.DarkGray,
                )
            },
            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            singleLine = singleLine,
            leadingIcon = if (leadingIcon != null) {
                val icon: @Composable () -> Unit = {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(25.dp)
                    )
                }
                icon
            } else null,
            trailingIcon = if (isPasswordToggleDisplayed) {
                val icon: @Composable () -> Unit = {
                    IconButton(
                        onClick = {
                            onPasswordToggleClick(!isPasswordVisible)
                        },
                        modifier = Modifier
                            .semantics {
//                                testTag = TestTags.PASSWORD_TOGGLE
                            }
                    ) {
                        Icon(
                            imageVector = if (isPasswordVisible) {
                                Icons.Filled.VisibilityOff
                            } else {
                                Icons.Filled.Visibility
                            },
                            tint = primaryPink,
                            contentDescription = if (isPasswordVisible) {
                                stringResource(id = R.string.password_visible_content_description)
                            } else {
                                stringResource(id = R.string.password_hidden_content_description)
                            },
                            modifier = Modifier.padding(end = 10.dp)
                        )
                    }
                }
                icon
            } else null,
            interactionSource = interactionSource,
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val strokeWidth = indicatorWidth.value * density
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        indicatorColor,
                        Offset(textFieldPadding.toPx(), y),
                        Offset(size.width - textFieldPadding.toPx(), y),
                        strokeWidth
                    )
                }
                .semantics {
//                    testTag = TestTags.STANDARD_TEXT_FIELD
                }
                .focusRequester(focusRequester = focusRequester),
            colors = textFieldColors

        )
        if (error.isNotEmpty()) {
            Text(
                text = error,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()

            )


        }
    }


}

@Composable
@Preview(showBackground = true)
fun CustmTextField() {
    var value by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "Email")
        AppTextField(
            text = value,
            onValueChange = {
                value= it
            },
            hint = "Email",
            keyboardType = KeyboardType.Password,
            isPasswordToggleDisplayed = true,
            error = "Error"

        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Password")
        StandardTextField(
            text = value,
            onValueChange = {
                value= it
            },
            hint = "Password",
            keyboardType = KeyboardType.Password,
            isPasswordToggleDisplayed = true,
            error = "Error"
        )


    }

}