package com.chachadeveloper.equitymobile.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.StandardTextField
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.destinations.HomeDestination
import com.chachadeveloper.equitymobile.presentation.destinations.RegisterDestination
import com.chachadeveloper.equitymobile.presentation.destinations.SecurityQnDestination
import com.chachadeveloper.equitymobile.presentation.securityQsn.SecurityQn
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.get

@Composable
@Destination(start = true)
fun Login(
    navigator: DestinationsNavigator,
    viewModel: LoginViewModel = get()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
                navigator = navigator,
                showBackArrow = true,
                title = {
                        Text(
                            text = "Welcome Back",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.body2
                        )
                },
                navActions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            painter = painterResource(id = R.drawable.chat_icon),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp),
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )
                    }
                }

            )

        Spacer(modifier = Modifier.height(25.dp))

        Column {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 25.dp, end = 25.dp)

                ){

                    Text(text = "Hello there", style = MaterialTheme.typography.body1)
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = stringResource(id = R.string.signin),
                        style =  MaterialTheme.typography.body2,
                        maxLines = 2
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Email address or mobile number")


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

                    Text(text = "Password")

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

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp),
                        text=stringResource(id = R.string.forgot_password),
                        color = primaryPink,
                        style = MaterialTheme.typography.body1,
                    )

                    Column (
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom
                    ){

                        Button(
                            onClick = {
                                navigator.navigate(HomeDestination)
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
