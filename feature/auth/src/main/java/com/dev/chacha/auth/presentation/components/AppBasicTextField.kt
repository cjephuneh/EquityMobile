package com.dev.chacha.auth.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.theme.primaryPink

@Composable
fun AppBasicTextField(
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
    onClick:()->Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(MutableInteractionSource(), null, onClickLabel = title.toString()) {
                onClick()
            },
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.titleSmall
        )

        BoxWithConstraints(
            modifier = Modifier.clipToBounds()
        ){
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredWidth(maxWidth + 16.dp)
                    .offset(x = (-8).dp,),
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
                            modifier = Modifier.size(24.dp)
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
                colors = colors,
                interactionSource = interactionSource

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
fun CustomTextField() {
    var value by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        AppTextField(
            text = value,
            onValueChange = {
                value = it
            },
            hint = "Email",
        )

        Spacer(modifier = Modifier.height(16.dp))
        AppBasicTextField(
            text = value,
            onValueChange = {
                value = it
            },
            hint = "Password",
            keyboardType = KeyboardType.Password,
            error = "Error",
            title = "Password",
            trailingIcon = {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.semantics {
                        contentDescription = "Password visibility toggle"
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropUp,
                        contentDescription = null
                    )
                }
            }

        )


    }

}