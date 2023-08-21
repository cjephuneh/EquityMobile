package com.dev.chacha.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.theme.primaryPink



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardBasicTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    title: String = "",
    onValueChange: (String) -> Unit,
    hint: String = "",
    maxLength: Int = 50,
    maxLines: Int = 1,
    enabled: Boolean = true,
    error: String = "",
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent
    ),
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth()
        )
        BasicTextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            maxLines = maxLines,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            enabled = enabled,
            singleLine = singleLine,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            modifier = Modifier.fillMaxWidth(),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            decorationBox = {innerTextField ->
                Column(
                    modifier = Modifier.drawWithContent {
                        drawContent()
                        drawLine(
                            color = Color(0xFF000000),
                            start = Offset(
                                x = 0f,
                                y = size.height - 1.dp.toPx(),
                            ),
                            end = Offset(
                                x = size.width,
                                y = size.height - 1.dp.toPx(),
                            ),
                            strokeWidth = 1.dp.toPx(),
                        )
                    },
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = hint,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        innerTextField()

                        Box(
                            contentAlignment = Alignment.CenterEnd
                        ){
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = Color(0xFFA8A8A8)
                                ,
                            )

                        }


                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }


            }

        )
        Box(modifier = modifier) {
            if (error.isNotEmpty()) {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizedTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    title: String = "",
    onValueChange: (String) -> Unit,
    hint: String = "",
    maxLength: Int = 50,
    maxLines: Int = 1,
    enabled: Boolean = true,
    error: String = "",
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent
    ),
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Box(
                contentAlignment = Alignment.CenterStart // Align hint to the start
            ){
                placeholder?.invoke() // Display placeholder/hint
            }

            BasicTextField(
                value = text,
                onValueChange = {
                    if (it.length <= maxLength) {
                        onValueChange(it)
                    }
                },
                maxLines = maxLines,
                visualTransformation = visualTransformation,
                interactionSource = interactionSource,
                enabled = enabled,
                singleLine = singleLine,
                textStyle = textStyle,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType
                ),
                modifier = Modifier.fillMaxWidth(),
                cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                decorationBox = {innerTextField ->
                    Column(
                        modifier = Modifier.drawWithContent {
                            drawContent()
                            drawLine(
                                color = Color(0xFF000000),
                                start = Offset(
                                    x = 0f,
                                    y = size.height - 1.dp.toPx(),
                                ),
                                end = Offset(
                                    x = size.width,
                                    y = size.height - 1.dp.toPx(),
                                ),
                                strokeWidth = 1.dp.toPx(),
                            )
                        },
                    ) {
                        innerTextField() // Inner text field

                        if (trailingIcon != null) {
                            trailingIcon() // Display trailing icon
                        }
                    }
                }
            )
        }

        Box(modifier = modifier) {
            if (error.isNotEmpty()) {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun StandardPreview() {
    var value by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        StandardBasicTextField(
            text = value,
            onValueChange = {
                value= it
            },
            hint = "Password",
            keyboardType = KeyboardType.Password,
            isPasswordToggleDisplayed = true,
            error = "Error",
            title = "Password Title"
        )
        CustomizedTextField(
            text = value,
            onValueChange = {
                value= it
            },
            hint = "Password",
            keyboardType = KeyboardType.Password,
            isPasswordToggleDisplayed = true,
            error = "Error",
            title = "Password"
        )
        StandardBasicTextField(
            text = value,
            onValueChange = {
                value= it
            },
            hint = "Password",
            keyboardType = KeyboardType.Password,
            isPasswordToggleDisplayed = true,
            error = "Error",
            title = "Password"
        )
    }
}







