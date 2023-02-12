package com.dev.chacha.more.presentation.reset_password_screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardTextField
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordScreen(
    viewModel: ResetPasswordViewModel,
    ) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Reset Password",
                showForwardArrow = true,
                showBackArrow = true
            )
        }
    ) {paddingValues ->

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
                            text = "Reset your password",
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = stringResource(id = R.string.createPassword_hint),
                            maxLines = 1,
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Current Password",
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
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

                        Spacer(modifier = Modifier.height(20.dp))


                        Text(
                            text = "New password",
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
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

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Confirm password",
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
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

                        Spacer(modifier = Modifier.height(20.dp))

                        /*
                        Password Validation Ui
                         */

                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 0.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,

                                ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(color = Color.White)
                                )
                                Text(
                                    text = stringResource(id = R.string.validate_header),
                                )

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 0.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(color = Color.White)
                                )

                                Text(
                                    text = stringResource(id = R.string.validateLetter),
                                    maxLines = 2,

                                    )


                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 0.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(color = Color.White)
                                )
                                Text(
                                    text = stringResource(id = R.string.validateCharLong),
                                    maxLines = 1,

                                    )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 0.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(color = Color.White)
                                )


                                Text(
                                    text = stringResource(id = R.string.validate_specialChar),
                                    maxLines = 1,
                                    )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 0.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(color = Color.White)
                                )

                                Text(
                                    text = stringResource(id = R.string.passwordMatch),
                                    maxLines = 1,

                                    )

                            }

                        }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 20.dp, end = 20.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {

                            Button(
                                onClick = {
//                                navigator.navigate(CreatePinDestination)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = Color.Red,
                                    containerColor = Color.DarkGray
                                ),

                                ) {
                                Text(
                                    text = "Confirm",
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                        }

                    }

                }
            }
        }

}

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        ResetPasswordScreen(viewModel = ResetPasswordViewModel())
    }

}
