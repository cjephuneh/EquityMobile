package com.chachadeveloper.equitymobile.presentation.login_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import com.chachadeveloper.equitymobile.presentation.components.*
import com.chachadeveloper.equitymobile.presentation.destinations.*
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.get

@Composable
@Destination(start = true)
fun LoginScreen(
    navigator: DestinationsNavigator,
    viewModel: LoginViewModel = get()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navigator = navigator,
            title = "Welcome",
            showForwardArrow = true,
            showBackArrow = true
        )

        Spacer(modifier = Modifier.height(25.dp))

        Column {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ){

                    Text(
                        text = "Hello there",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(start = 20.dp)

                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = stringResource(id = R.string.signin),
                        style =  MaterialTheme.typography.body2,
                        maxLines = 2,
                        modifier = Modifier.padding(start = 16.dp)

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
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Password",
                        modifier = Modifier.padding(start = 20.dp)
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
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        modifier = Modifier
                            .padding(start = 24.dp),
                        text=stringResource(id = R.string.forgot_password),
                        color = primaryPink,
                        style = MaterialTheme.typography.body2,
                    )

                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp),
                        verticalArrangement = Arrangement.Bottom
                    ){
                        OutlinedButton(
                            onClick = {
                                navigator.navigate(RegisterScreenDestination)
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Color.White,
                                backgroundColor = Color.Transparent,
                            ),
                            border = BorderStroke(1.dp, primaryPink),
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
                                navigator.navigate(CodeVerificationScreenDestination)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Red,
                                backgroundColor = Color.DarkGray
                            ),

                            ) {
                            Text(
                                text = "Enter password to sign in",
                                color = Color.Black,
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
