package com.dev.chacha.auth.presentation.create_password_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardTextField
import com.dev.chacha.ui.common.components.StandardToolbar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePasswordScreen(
    onClickAction: () -> Unit,
    viewModel: CreatePasswordViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            title = "Create Password",

            )
        Spacer(modifier = Modifier.height(25.dp))
        Column {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Text(
                        text = stringResource(id = R.string.createPasswd_header),
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
                        text = "Password",
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp)

                    )

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


                    Text(
                        text = "Confirm password",
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp)

                    )

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

                    Spacer(modifier = Modifier.height(30.dp))

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
                                painter =
                                painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp),
                                contentScale = ContentScale.Crop,
                                colorFilter = ColorFilter.tint(color = Color.White)
                            )
                            Text(
                                text = stringResource(id = R.string.validate_header),
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))

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

                        Spacer(modifier = Modifier.height(8.dp))

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
                        Spacer(modifier = Modifier.height(8.dp))

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

                        Spacer(modifier = Modifier.height(8.dp))

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
                    /* Button */

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {

                        Button(
                            onClick = {
/*
                                navigator.navigate(CreatePinScreenDestination)
*/
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
                        Spacer(modifier = Modifier.height(25.dp))

                    }

                }


            }


        }

    }

}