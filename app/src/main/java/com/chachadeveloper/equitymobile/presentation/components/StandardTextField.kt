package com.chachadeveloper.equitymobile.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.util.TestTags
import com.chachadeveloper.equitymobile.ui.theme.Transparent
import com.chachadeveloper.equitymobile.ui.theme.primaryPink

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    labelText: String = "",
    hint: String = "",
    maxLength: Int = 50,
    error: String = "",
    style: TextStyle = TextStyle(
        color = MaterialTheme.colors.onBackground
    ),
    singleLine: Boolean = true,
    maxLines: Int = 1,
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit,
    focusRequester: FocusRequester = FocusRequester()
){
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val IndicatorUnfocusedWidth = 1.dp
    val IndicatorFocusedWidth = 2.dp
    val TextFieldPadding = 16.dp
    val color = Color.White.copy(alpha = 0.78F)
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = color,
        cursorColor = color,
        leadingIconColor = color,
        trailingIconColor = color,
        focusedBorderColor = Transparent,
        unfocusedBorderColor = Transparent,
        focusedLabelColor = Transparent,
        unfocusedLabelColor = color,
        disabledBorderColor = Transparent

    )

    val indicatorColor = if (isFocused) primaryPink else Color.DarkGray
    val indicatorWidth = if (isFocused) IndicatorFocusedWidth else IndicatorUnfocusedWidth

    Column(modifier = Modifier.fillMaxWidth().padding(start = 4.dp, end = 4.dp))  {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
//            label = {
//                Text(
//                    text = labelText,
//                    style = MaterialTheme.typography.body1,
//                    color = Color.DarkGray,
//                )
//            },
            maxLines = maxLines,
            textStyle = style,
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.body1,
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
                        tint = MaterialTheme.colors.onBackground,
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
                                testTag = TestTags.PASSWORD_TOGGLE
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
            } else null


            ,



            interactionSource = interactionSource,
            modifier = Modifier.fillMaxWidth()
                .drawBehind {
                    val strokeWidth = indicatorWidth.value * density
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        indicatorColor,
                        Offset(TextFieldPadding.toPx(), y),
                        Offset(size.width - TextFieldPadding.toPx(), y),
                        strokeWidth
                    )
                }
                .semantics {
                    testTag = TestTags.STANDARD_TEXT_FIELD
                }
                .focusRequester(focusRequester = focusRequester),
            colors = textFieldColors
            /*colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent,
                disabledIndicatorColor = Transparent
            )*/
        )


        if (error.isNotEmpty()) {
            Text(
                text = error,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()

            )


        }
    }



}