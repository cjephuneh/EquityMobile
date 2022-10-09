package com.chachadeveloper.equitymobile.presentation.auth_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.destinations.LoginScreenDestination
import com.chachadeveloper.equitymobile.presentation.destinations.RegisterScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlin.system.exitProcess

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Destination

fun AuthScreen(
    navigator: DestinationsNavigator
) {
    Dialog(
        onDismissRequest = {
            exitProcess(0)
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ){
        Column {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ){
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                        .padding(start = 30.dp, end = 30.dp)
                ) {
                    
                    Text(
                        text = "Welcome to Equity Mobile",
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp
                    )
                    
                }

                Image(painter = painterResource(id = R.drawable.ic_loan),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,

                )
                Image(
                    painter = painterResource(id = R.drawable.ic_loan),
                    contentDescription = null,
                    modifier = Modifier
                        .width(150.dp)
                        .height(120.dp)
                        .padding(horizontal = 24.dp, vertical = 24.dp),
                    contentScale = ContentScale.Fit,
                )
                Column(modifier = Modifier
                    .fillMaxSize().padding(start = 30.dp, end = 30.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    
                    Text(
                        text = "Good evening! Sign in or register to continue",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedButton(
                        onClick = {
                            navigator.navigate(LoginScreenDestination)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.White,
                            backgroundColor = Color.Transparent,
                        ),
                        border = BorderStroke(1.dp, Color.White),
                        shape = RoundedCornerShape(8)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            text = "Enter password to sign in",
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(
                        onClick = {
                            navigator.navigate(RegisterScreenDestination)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                        shape = RoundedCornerShape(8),
                        colors = ButtonDefaults.buttonColors(
/*
                            contentColor = Color.Red,
*/
                            backgroundColor = Color.White
                        ),

                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            text = "Register",
                            color = Color.Red,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))


                }
            }
        }


    }


}