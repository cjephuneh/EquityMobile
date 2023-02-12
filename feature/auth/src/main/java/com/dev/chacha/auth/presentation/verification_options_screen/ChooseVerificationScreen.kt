package com.dev.chacha.auth.presentation.verification_options_screen

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Forward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.fingerprint_screen.FingerPrintScreen
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryPink


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseVerificationScreen(
) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
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

                    Text(
                        text = stringResource(id = R.string.verify_header),
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = stringResource(id = R.string.select_hint),
                        maxLines = 2
                    )

                    /*cards for verification
                    * */

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(end = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = Modifier
                                    .width(250.dp)
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = "By Card",
                                    maxLines = 1,
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "ATM, debit or credit card",
                                    maxLines = 1,
                                )
                            }
                            Image(
                                imageVector = Icons.Filled.Forward,
                                contentDescription = null
                            )

                        }

                    }

                    /*Card 2 verification
                    * */

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(end = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = Modifier
                                    .width(250.dp)
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = "By Sms",
                                    maxLines = 1,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "25474*****13",
                                    maxLines = 1,
                                    color = Color.Black

                                )
                            }
                            Image(
                                imageVector = Icons.Filled.Forward,
                                contentDescription = null
                            )

                        }

                    }

/*
                    Spacer(modifier = Modifier.height(16.dp))
*/

                    /* verification 3
                    * */

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(end = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = Modifier
                                    .width(250.dp)
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = "By Email",
                                    maxLines = 1,
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "s********A4@GMAIL>COM",
                                    maxLines = 1,
                                )
                            }
                            Image(
                                imageVector = Icons.Filled.Forward,
                                contentDescription = null
                            )

                        }

                    }

                    /* Buttons
                           */

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp, vertical = 16.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        OutlinedButton(
                            onClick = {
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp, end = 8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Color.White,
                                containerColor = Color.Transparent,
                            ),
                            border = BorderStroke(1.dp, primaryPink
                            ),
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


@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        ChooseVerificationScreen()
    }

}
