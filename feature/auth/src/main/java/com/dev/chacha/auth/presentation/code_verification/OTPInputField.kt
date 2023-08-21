package com.dev.chacha.auth.presentation.code_verification

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.auth.presentation.register.CountriesBottomSheets
import com.dev.chacha.ui.common.base.AppViewModel
import com.dev.chacha.ui.common.base.BottomSheetWrapper
import com.dev.chacha.ui.common.base.PathState
import com.dev.chacha.util.Graph
import kotlinx.coroutines.launch


@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun OTPInputField(
    modifier: Modifier = Modifier,
    onOtpChange: (String) -> Unit,
    otpLength: Int,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    navController: NavController,
    appViewModel: AppViewModel = viewModel()
) {
    val permissionState = remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current
    var otpValue by remember { mutableStateOf("") }
    val keyboardState = keyboardAsState(KeyboardState.Closed)
    val isShowingWarning by remember(keyboardState) {
        derivedStateOf {
            if (keyboardState.value == KeyboardState.Closed) {
                return@derivedStateOf otpValue.length != otpLength
            }
            return@derivedStateOf false
        }
    }
    val focusRequester = remember {
        FocusRequester()
    }


    BasicTextField(
        value = otpValue,
        onValueChange = { value ->
            if (value.length <= otpLength) {
                otpValue = value
                onOtpChange(otpValue)

            }
        },
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        singleLine = singleLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        ),
        decorationBox = { innerTextField ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(otpLength) { index ->
                    val char = when {
                        index < otpValue.length -> otpValue[index].toString()
                        else -> ""
                    }
                    val isFocus = index == otpValue.length
                    OTPCell(
                        char = char,
                        isFocus = isFocus,
                        isShowingWarning = isShowingWarning,
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                appViewModel.openSheet(PathState(SMS_BOTTOMSHEET))
                                if (index == 0) {
                                    permissionState.value = true
                                }
                            }
                    )
                }
            }
            innerTextField()
        },
        modifier = Modifier.focusRequester(focusRequester),
    )

    // Show an error alert when the condition is not met
    if (otpValue.length == otpLength && otpValue != "123456") {
        AlertDialog(
            onDismissRequest = { /* handle dismiss if needed */ },
            title = { Text(text = "Error") },
            text = { Text(text = "Incorrect OTP code. Please try again.") },
            confirmButton = {
                Button(
                    onClick = {
                        // Clear the otpValue and any other necessary actions
                        otpValue = ""
                    }
                ) {
                    Text(text = "OK")
                }
            }
        )
    }


    // Use LaunchedEffect to trigger navigation when the condition is met
    LaunchedEffect(otpValue) {
        if (otpValue.length == otpLength && otpValue == "123456") {
            navController.navigate(Graph.HOME_SCREEN_ROUTE)
        } 
    }


    if (permissionState.value) {

        BottomSheetWrapper(name = SMS_BOTTOMSHEET) {
            PermissionBottomSheet(
                onPermissionGranted = {
                    otpValue = "123456"
                    onOtpChange(otpValue)
                    permissionState.value = false
                },
                onPermissionDenied = {
                    permissionState.value = false
                }
            )
        }

    }


    LaunchedEffect(key1 = true) {
        focusRequester.requestFocus()
        keyboardController?.hide()
    }

}

const val SMS_BOTTOMSHEET = "bottomsheetss"

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PermissionBottomSheet(
    onPermissionGranted: () -> Unit,
    onPermissionDenied: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Allow OTP autofill?",
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {
                    onPermissionGranted()
                }
            ) {
                Text(text = "Allow")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    onPermissionDenied()
                }
            ) {
                Text(text = "Deny")
            }

        }

    }

}


@Composable
@Preview
fun OTPInputPreview() {
    MaterialTheme {
        Box(modifier = Modifier.padding(24.dp)) {
            OTPInputField(otpLength = 6, onOtpChange = {}, navController = rememberNavController())
        }
    }
}

@Composable
fun OTPCell(
    char: String,
    isFocus: Boolean,
    isShowingWarning: Boolean,
    modifier: Modifier = Modifier
) {
    val borderColor = if (isShowingWarning) {
        MaterialTheme.colorScheme.error
    } else if (isFocus) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.secondary
    }

    Surface(
        modifier = modifier
            .aspectRatio(1f)
            .border(1.dp, color = borderColor, MaterialTheme.shapes.small)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = char,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
        }

    }

}

@Composable
@Preview
fun PreviewOTPCell() {
    MaterialTheme {
        Box(modifier = Modifier.padding(24.dp)) {
            OTPCell(char = "7", isFocus = true, isShowingWarning = false)
        }
    }
}