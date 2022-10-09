package com.chachadeveloper.equitymobile.feature_auth.presentation.fingerprint_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryPink
import com.chachadeveloper.equitymobile.destinations.LoginScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun FingerPrintScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
     /*   CustomToolbar(
            navigator = navigator,
            showBackArrow = true,
            title = {
                Text(
                    text = "Set up FingerPrint ID",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body2
                )
            }
        )*/
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icons.Filled.Fingerprint
            }

            Text(text = "Sign in with Fingerprint ID")
            Text(text = "You can use Fingerprint ID to sign in")

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp, end = 30.dp),
                verticalArrangement = Arrangement.Bottom
            ) {


                Spacer(modifier = Modifier.height(16.dp))
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
                        text = "Skip this step",
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
/*
                            contentColor = Color.Red,
*/
                        containerColor = primaryPink
                    ),

                    ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        textAlign = TextAlign.Center,
                        text = "Ok, set up now",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))


            }


        }

    }

}
