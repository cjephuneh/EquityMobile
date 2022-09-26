package com.chachadeveloper.equitymobile.presentation.changeResetPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
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
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.StandardTextField
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.createPassword.CreatePasswordViewModel
import com.chachadeveloper.equitymobile.presentation.destinations.CreatePinDestination
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.get

@Composable
@Destination
fun ResetPassword(
    viewModel: ResetPasswordViewModel = get(),
    navigator: DestinationsNavigator

) {

    Column(modifier = Modifier.fillMaxSize()) {
             StandardToolbar(
            navigator = navigator,
                 showBackArrow = true,
            title = {
                Text(
                    text = "Change Password",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body2
                )
            }
        )

        Column {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {

                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(start = 30.dp, end = 30.dp)
                ) {

                    Text(
                        text = "Reset your password",
                        style = MaterialTheme.typography.body1
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = stringResource(id = R.string.createPassword_hint),
                        style = MaterialTheme.typography.body2,
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
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
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
                                modifier = Modifier.padding(top = 5.dp),
                                textAlign = TextAlign.Center
                            )

                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Icon(
                                imageVector = Icons.Filled.Save,
                                contentDescription = null
                            )

                            Column {
                                Text(
                                    text = stringResource(id = R.string.validateLetter),
                                    maxLines = 2,
                                    style = MaterialTheme.typography.body2
                                )

                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Icon(
                                imageVector = Icons.Filled.Save,
                                contentDescription = null
                            )

                            Column {
                                Text(
                                    text = stringResource(id = R.string.validateCharLong),
                                    maxLines = 1,
                                    style = MaterialTheme.typography.body2

                                )

                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Icon(
                                imageVector = Icons.Filled.Save,
                                contentDescription = null
                            )

                            Column {
                                Text(
                                    text = stringResource(id = R.string.validate_specialChar),
                                    maxLines = 1,
                                    style = MaterialTheme.typography.body2


                                )

                            }
                        }


                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Icon(
                                imageVector = Icons.Filled.Save,
                                contentDescription = null
                            )

                            Column {
                                Text(
                                    text = stringResource(id = R.string.passwordMatch),
                                    maxLines = 1,
                                    style = MaterialTheme.typography.body2

                                )

                            }
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
                                    backgroundColor = Color.DarkGray
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