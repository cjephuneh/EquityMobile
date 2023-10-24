package com.dev.chacha.auth.presentation.code_verification

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.auth.presentation.navigation.AuthScreen
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dev.chacha.data.BiometricViewModel
import com.dev.chacha.ui.common.theme.HintGray


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
) {
    val permissionState = remember { mutableStateOf(false) }
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }

    val biometricViewModel: BiometricViewModel = hiltViewModel()
    val biometricUiState by biometricViewModel.uiState.collectAsStateWithLifecycle()

    val bottomSheetState = rememberModalBottomSheetState()

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
                verticalAlignment = Alignment.CenterVertically,
            ) {
                repeat(otpLength) { index ->
                    val char = when {
                        index < otpValue.length -> otpValue[index].toString()
                        else -> ""
                    }
                    val isFocus = index == otpValue.length
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center
                    ){
                        OTPCell(
                            char = char,
                            isFocus = isFocus,
                            isShowingWarning = isShowingWarning,
                            modifier = Modifier
                                .clickable {
                                    isSheetOpen = true
                                    if (index == 0) {
                                        permissionState.value = true
                                    }
                                }
                        )
                    }

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
            if (biometricUiState.isBiometricEnabled){
                navController.navigate(AuthScreen.MainLogin.route)
            } else{
                navController.navigate(AuthScreen.BiometricSetUp.route)
            }
        }
    }

    val code = "123456"
    if (permissionState.value) {
        if (isSheetOpen) {
            ModalBottomSheet(
                onDismissRequest = {
                    isSheetOpen = false
                },
                sheetState = bottomSheetState,
                dragHandle = null,
                shape = RoundedCornerShape(0.dp)
            ) {
                PermissionBottomSheet(
                    titleMessage = "Allow Equity Mobile to read the message and enter the code",
                    message = "Never share this code with anyone,including us. Use $code to sign in",
                    onPermissionGranted = {
                        otpValue = code
                        onOtpChange(otpValue)
                        permissionState.value = false
                    },
                    onPermissionDenied = {
                        permissionState.value = false
                    }
                )

            }
        }
    }

    LaunchedEffect(key1 = true) {
        focusRequester.requestFocus()
        keyboardController?.hide()
    }

}


@Composable
fun PermissionBottomSheet(
    onPermissionGranted: () -> Unit,
    onPermissionDenied: () -> Unit,
    titleMessage: String ="",
    message: String = ""
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .safeGesturesPadding()
            .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = titleMessage,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold

        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = message,
            style = MaterialTheme.typography.titleSmall,
            color = HintGray
        )



        Row(
            modifier = Modifier
                .align(Alignment.End),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
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
        MaterialTheme.colorScheme.onBackground
    }

    Surface(
        modifier = modifier
            .background(HintGray, MaterialTheme.shapes.small)
            .aspectRatio(1f)
            .border(
                1.dp,
                color = HintGray,
                MaterialTheme.shapes.small
            )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.wrapContentSize()
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