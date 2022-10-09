package com.chachadeveloper.equitymobile.feature_transaction.presentation.create_pin_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardTextField
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardToolbar
import com.chachadeveloper.equitymobile.core.presentation.common.theme.EquityMobileTheme
import com.chachadeveloper.equitymobile.destinations.SecurityQnScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.get

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun CreatePinScreen(
    navigator: DestinationsNavigator,
    viewModel: CreatePinViewModel = get()) {
    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        StandardToolbar(
            navigator = navigator,
            showBackArrow = true,
            title = "Create Pin",
            showForwardArrow = true,
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column{
                    Text(
                        text = stringResource(id = R.string.createPin_header),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = stringResource(id = R.string.createPin_hint),
                        style =  MaterialTheme.typography.body2,
                        maxLines = 1,
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp)

                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "PIN",
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
                    Spacer(modifier = Modifier.height(22.dp))
                    Text(
                        text = "Confirm PIN",
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
                    Spacer(modifier = Modifier.height(50.dp))

                    /*
                    Pin Validation Ui
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
                                text = stringResource(id = R.string.pinValidate_header),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                fontSize = 12.sp
                            )

                        }
                        Spacer(modifier = Modifier.height(10.dp))
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
                                text = stringResource(id = R.string.validateSequence),
                                fontSize = 12.sp
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

                                text = stringResource(id = R.string.validateRepetetive),
                                fontSize = 12.sp
                            )

                        }
                    }
                    /* Button */
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp),
                        verticalArrangement = Arrangement.Bottom
                    ){
                        Button(
                            onClick = {
                                navigator.navigate(SecurityQnScreenDestination)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Red,
                                containerColor = Color.DarkGray
                            ),

                            ) {
                            Text(
                                text = "Set PIN",
                                color = Color.Black,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(35.dp))

                    }

                }

            }

        }

    }
}

@Composable
@Preview
fun CreatePinPreView() {
    EquityMobileTheme {
//        CreatePinScreen(navigator = )
    }

}