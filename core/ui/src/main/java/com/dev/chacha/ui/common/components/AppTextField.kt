package com.dev.chacha.ui.common.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
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
fun AppTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    title: String = "",
    onValueChange: (String) -> Unit,
    hint: String = "",
    maxLength: Int = 30,
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
    isPinToggleDisplayed: Boolean = keyboardType == KeyboardType.NumberPassword,
    isPasswordVisible: Boolean = false,
    isPinVisible: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onPinToggleClick: (Boolean) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent
    ),
    onClick:()->Unit = {},
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
            style = MaterialTheme.typography.labelSmall
        )

        BoxWithConstraints(
           modifier = Modifier.clipToBounds().height(56.dp)
        ){
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredWidth(maxWidth + 16.dp)
                    .offset(x = (-8).dp),
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
                        style = MaterialTheme.typography.labelSmall

                    )
                },
                isError = error != "",
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType
                ),
                visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
                    PasswordVisualTransformation()
                } else if (!isPinVisible && isPinToggleDisplayed) {
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
                trailingIcon = if (isPasswordToggleDisplayed || isPinToggleDisplayed) {
                    val icon: @Composable () -> Unit = {
                        IconButton(
                            onClick = {
                                onPasswordToggleClick(!isPasswordVisible)
                                onPinToggleClick(!isPinVisible)

                            },
                            modifier = Modifier
                                .semantics {
//                                testTag = TestTags.PASSWORD_TOGGLE
                                }
                        ) {
                            Icon(
                                imageVector = if (isPasswordVisible || isPinVisible) {
                                    Icons.Filled.VisibilityOff
                                } else {
                                    Icons.Filled.Visibility
                                },
                                tint = MaterialTheme.colorScheme.primary,
                                contentDescription = if (isPasswordVisible || isPinVisible) {
                                    stringResource(id = R.string.password_visible_content_description)
                                } else {
                                    stringResource(id = R.string.password_hidden_content_description)
                                },
                            )
                        }
                    }
                    icon
                } else null,
                colors = colors,
                interactionSource = interactionSource,
                enabled = enabled


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
fun CustomTextField() {
    var value by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        AppTextField(
            title = "Email",
            text = value,
            onValueChange = {
                value= it
            },
            hint = "Email",
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        AppTextField(
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