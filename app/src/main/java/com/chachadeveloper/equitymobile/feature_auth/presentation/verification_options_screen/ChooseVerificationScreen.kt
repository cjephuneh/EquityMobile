package com.chachadeveloper.equitymobile.feature_auth.presentation.verification_options_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Forward
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardToolbar
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryPink
import com.chachadeveloper.equitymobile.destinations.LoginScreenDestination
import com.chachadeveloper.equitymobile.destinations.RegisterScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun ChooseVerificationScreen(
    navigator: DestinationsNavigator
) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navigator = navigator,
            showBackArrow = true,
            title = "Verify",
        )
        Column {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 30.dp, end = 30.dp)
                ) {

                    Text(text = stringResource(id = R.string.verify_header), style = MaterialTheme.typography.body1)
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = stringResource(id = R.string.select_hint),
                        style =  MaterialTheme.typography.body2,
                        maxLines = 2
                    )

                    /*cards for verification
                    * */

                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(8.dp),
                        shape= RoundedCornerShape(20.dp)
                    ){
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(end = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                contentDescription =  null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Column (modifier = Modifier
                                .width(250.dp)
                                .padding(10.dp)
                            ){
                                Text(
                                    text = "By Card" ,
                                    maxLines = 1,
                                    style= MaterialTheme.typography.body1,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(text = "ATM, debit or credit card",
                                    maxLines = 1,
                                    style = MaterialTheme.typography.body2,
                                    color = Color.Black

                                )
                            }
                            Image(imageVector = Icons.Filled.Forward,
                                contentDescription = null
                            )

                        }

                    }

                    /*Card 2 verification
                    * */

                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(8.dp),
                        shape= RoundedCornerShape(20.dp)
                    ){
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(end = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                contentDescription =  null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Column (modifier = Modifier
                                .width(250.dp)
                                .padding(10.dp)
                            ){
                                Text(
                                    text = "By Sms" ,
                                    maxLines = 1,
                                    style= MaterialTheme.typography.body1,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(text = "25474*****13",
                                    maxLines = 1,
                                    style = MaterialTheme.typography.body2,
                                    color = Color.Black

                                )
                            }
                            Image(imageVector = Icons.Filled.Forward,
                                contentDescription = null
                            )

                        }

                    }

/*
                    Spacer(modifier = Modifier.height(16.dp))
*/

                    /* verification 3
                    * */

                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(8.dp),
                        shape= RoundedCornerShape(20.dp)
                    ){
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(end = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                contentDescription =  null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Column (modifier = Modifier
                                .width(250.dp)
                                .padding(10.dp)
                            ){
                                Text(
                                    text = "By Email" ,
                                    maxLines = 1,
                                    style= MaterialTheme.typography.body1,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(text = "s********A4@GMAIL>COM",
                                    maxLines = 1,
                                    style = MaterialTheme.typography.body2,
                                    color = Color.Black

                                )
                            }
                            Image(imageVector = Icons.Filled.Forward,
                                contentDescription = null
                            )

                        }

                    }

                    /* Buttons
                           */

                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        OutlinedButton(
                            onClick = {
                                navigator.navigate(LoginScreenDestination)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp, end = 8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Color.White,
                                containerColor = Color.Transparent,
                            ),
                            border = BorderStroke(1.dp, primaryPink),
                            shape = RoundedCornerShape(8)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                textAlign = TextAlign.Center,
                                text = "I've changed my contact details",
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
                                containerColor = Color.DarkGray
                            ),

                            ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                textAlign = TextAlign.Center,
                                text = "Confirm",
                                fontSize = 16.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        /* End of Button*/


                    }


                }


            }
        }


    }
}