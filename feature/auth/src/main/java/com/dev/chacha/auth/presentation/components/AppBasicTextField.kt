package com.dev.chacha.auth.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.components.AppTextField

@Composable
fun AppBasicTextField(
    text: String = "",
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "",
    maxLength: Int = 50,
    maxLines: Int = 1,
    enabled: Boolean = true,
    error: String = "",
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
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
    title: String = ""

) {
    Column(
        modifier = Modifier.fillMaxWidth(),
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
            decorationBox = { innerTextField ->
                TextFieldDefaults.TextFieldDecorationBox(
                    value = text,
                    visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
                        PasswordVisualTransformation()
                    } else {
                        VisualTransformation.None
                    },
                    innerTextField = innerTextField,
                    singleLine = singleLine,
                    enabled = enabled,
                    colors = colors,
                    isError = error != "",
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(start=0.dp,end=0.dp, bottom = 12.dp),
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
                    placeholder = {
                        Text(
                            text = hint,
                            color = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
                            textAlign = TextAlign.Start
                        )
                    },
                    trailingIcon = trailingIcon,

                    // this is how you can remove the padding
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        )
        Box(
            modifier = modifier
        ) {
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
fun CustomTextField() {
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