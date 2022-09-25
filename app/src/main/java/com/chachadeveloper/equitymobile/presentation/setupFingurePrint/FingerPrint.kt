package com.chachadeveloper.equitymobile.presentation.setupFingurePrint

import android.Manifest
import android.app.KeyguardManager
import android.content.Context
import android.content.Context.KEYGUARD_SERVICE
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.provider.Settings.Secure.getString
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.CustomToolbar
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.destinations.LoginDestination
import com.chachadeveloper.equitymobile.presentation.destinations.RegisterDestination
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun FingerPrint(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
        CustomToolbar(
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
        )
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
                .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {


                Spacer(modifier = Modifier.height(16.dp))
                OutlinedButton(
                    onClick = {
                        navigator.navigate(LoginDestination)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
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
                        backgroundColor = primaryPink
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
