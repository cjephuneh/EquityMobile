package com.dev.chacha.more.presentation.reset_pin_screen

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
fun ResetPinScreen(
    viewModel: ResetPinViewModel,

    ) {

    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Change Pin",
                showBackArrow = true
            )

        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {
            Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 30.dp, end = 30.dp)
                    ) {

                        Text(
                            text = "Reset your password",
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = stringResource(id = R.string.createPassword_hint),
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = "Current Password")

                        StandardTextField(
                            text = viewModel.passwordText.value,
                            onValueChange = {
                                viewModel.setPasswordText(it)
                            },
                            hint = stringResource(id = R.string.password_hint),
                            keyboardType = KeyboardType.Password,
                            error = viewModel.passwordError.value,
                            isPasswordVisible = viewModel.showPassword.value,
                            onPasswordToggleClick = {
                                viewModel.setShowPassword(it)
                            }
                        )

                        Spacer(modifier = Modifier.height(20.dp))


                        Text(text = "New password")

                        StandardTextField(
                            text = viewModel.passwordText.value,
                            onValueChange = {
                                viewModel.setPasswordText(it)
                            },
                            hint = stringResource(id = R.string.password_hint),
                            keyboardType = KeyboardType.Password,
                            error = viewModel.passwordError.value,
                            isPasswordVisible = viewModel.showPassword.value,
                            onPasswordToggleClick = {
                                viewModel.setShowPassword(it)
                            }
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = "Confirm password")


                        StandardTextField(
                            text = viewModel.passwordText.value,
                            onValueChange = {
                                viewModel.setPasswordText(it)
                            },
                            hint = stringResource(id = R.string.password_hint),
                            keyboardType = KeyboardType.Password,
                            error = viewModel.passwordError.value,
                            isPasswordVisible = viewModel.showPassword.value,
                            onPasswordToggleClick = {
                                viewModel.setShowPassword(it)
                            }
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        /*
                        Password Validation Ui
                         */

                        Column {
                            Row(modifier = Modifier.fillMaxWidth()) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(color = Color.White)
                                )
                                Text(
                                    text = stringResource(id = R.string.pinValidate_header),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 5.dp)
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(color = Color.White)
                                )

                                Text(text = stringResource(id = R.string.validateSequence))


                            }

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(color = Color.White)
                                )

                                Text(text = stringResource(id = R.string.validateRepetetive))


                            }

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(color = Color.White)
                                )

                                Text(text = "Don't use a previous or old PIN")


                            }

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(color = Color.White)
                                )

                                Text(text = "The PIN must match")


                            }
                        }




                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
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
                                    text = "set PIN",
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
        ResetPinScreen(viewModel = ResetPinViewModel())
    }

}
