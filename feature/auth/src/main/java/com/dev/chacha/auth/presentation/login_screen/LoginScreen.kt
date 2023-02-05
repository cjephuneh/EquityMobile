package com.dev.chacha.auth.presentation.login_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardTextField
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryPink


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onNavigateToHome: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit,
    viewModel: LoginViewModel,
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Welcome", showForwardArrow = true, showBackArrow = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Text(
                        text = "Hello there",
                        modifier = Modifier.padding(start = 20.dp)

                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = stringResource(id = R.string.signin),
                        maxLines = 2,
                        modifier = Modifier
                            .padding(start = 20.dp , end = 20.dp)

                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Email address or mobile number",
                        modifier = Modifier.padding(start = 20.dp)
                    )

                    StandardTextField(
                        text = viewModel.usernameText.value,
                        onValueChange = {
                            viewModel.setUsernameText(it)
                        },
                        keyboardType = KeyboardType.Email,
                        error = viewModel.usernameError.value,
                        hint = stringResource(id = R.string.email_hint),

                        )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Password", modifier = Modifier.padding(start = 20.dp)
                    )

                    StandardTextField(text = viewModel.passwordText.value,
                        onValueChange = {
                            viewModel.setPasswordText(it)
                        },
                        hint = stringResource(id = R.string.password_hint),
                        keyboardType = KeyboardType.Password,
                        error = viewModel.passwordError.value,
                        isPasswordVisible = viewModel.showPassword.value,
                        onPasswordToggleClick = {
                            viewModel.setShowPassword(it)
                        })
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        modifier = Modifier.padding(start = 24.dp),
                        text = stringResource(id = R.string.forgot_password),
                        color = primaryPink,
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        OutlinedButton(
                            onClick = {
                                      onSignUpClick()
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = Color.Transparent,
                            ),
                            border = BorderStroke(
                                1.dp, primaryPink
                            ),
                            shape = RoundedCornerShape(8)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                textAlign = TextAlign.Center,
                                text = "Register",
                                fontSize = 14.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Button(
                            onClick = {
                                onNavigateToHome()
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                            ),
                            shape = RoundedCornerShape(8),

                        ) {
                            Text(
                                text = "Enter password to sign in",
                                fontSize = 16.sp,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))

                    }

                }

            }

        }

    }
}

@Composable
@Preview(showBackground = true)
fun LoginPreview() {
    EquityMobileTheme {
        LoginScreen(
            onNavigateToHome = { /*TODO*/ },
            onSignUpClick = { /*TODO*/ },
            onForgotClick = {},
            viewModel = LoginViewModel()
        )
    }
}
