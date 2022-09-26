package com.chachadeveloper.equitymobile.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.presentation.util.TestTags
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.ui.theme.primaryPink

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    label: String = "",
    maxLength: Int = 40,
    singleLine: Boolean = true,
    maxLines:Int = 1,
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit,
    error: String = "",
    style: TextStyle = TextStyle(
        color = MaterialTheme.colors.onBackground
    )

) {

    val color = Color.White.copy(alpha = 0.78F)
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = color,
        cursorColor = color,
        leadingIconColor = color,
        trailingIconColor = color,
        focusedBorderColor = primaryPink,
        unfocusedBorderColor = color.copy(alpha = 0.5F),
        focusedLabelColor = Color.White,
        unfocusedLabelColor = color
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange ={
                if (it.length <= maxLength){
                    onValueChange(it)
                }
            },


            maxLines = maxLines,
            textStyle = style,
            placeholder = {
                Text(
                    text = hint,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body1,
                    color = Color.DarkGray,
                    modifier = Modifier.fillMaxWidth()

                )
            },
            isError = error !="",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed){
                PasswordVisualTransformation()
            } else{
                VisualTransformation.None
            },
            singleLine = singleLine,
            leadingIcon = if ( leadingIcon != null){
                val icon: @Composable () -> Unit = {
                    Icon(imageVector = leadingIcon ,
                        contentDescription = null,
                        tint = primaryPink,
                        modifier = Modifier.size(25.dp)
                    )
                }
                icon
            } else null,
            trailingIcon = if(isPasswordToggleDisplayed) {
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
                            tint = Color.DarkGray,
                            contentDescription = if (isPasswordVisible) {
                                stringResource(id = R.string.password_visible_content_description)
                            } else {
                                stringResource(id = R.string.password_hidden_content_description)
                            }
                        )
                    }
                }
                icon
            } else null,

            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    testTag = TestTags.STANDARD_TEXT_FIELD
                },
            colors = textFieldColors /*TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
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