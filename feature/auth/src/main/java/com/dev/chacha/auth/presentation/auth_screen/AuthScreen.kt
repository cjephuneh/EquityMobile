package com.dev.chacha.auth.presentation.auth_screen


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.extensions.greeting
import com.dev.chacha.ui.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AuthScreen(
    onSignUp: () -> Unit, onLogin: () -> Unit

) {


    val buttonScale = remember { Animatable(1f) }
    val coroutineScope = rememberCoroutineScope()

    // Set initial visibility state of buttons
    var signInVisible by remember { mutableStateOf(false) }
    var registerVisible by remember { mutableStateOf(false) }

    val signInPosition by animateDpAsState(targetValue = if (signInVisible) 0.dp else 100.dp, label = "")
    val registerPosition by animateDpAsState(targetValue = if (registerVisible) 0.dp else 100.dp, label = "")





    LaunchedEffect(Unit) {
        // Trigger the visibility animations with a delay
        delay(200)
        signInVisible = true
        delay(100)
        registerVisible = true
    }



    Scaffold(
        topBar = {
            Icon(
                painter = painterResource(id = R.drawable.equitybank_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(horizontal = 16.dp),
                tint = Color.White
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "$greeting! Sign in or register to continue",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.White
                    )
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { onLogin() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .offset(y = signInPosition),
                    shape = RoundedCornerShape(12),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = MaterialTheme.colorScheme.primary,
                        containerColor =MaterialTheme.colorScheme.background
                    )
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Sign in",
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Button(
                    onClick = { onSignUp() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .offset(y = registerPosition),
                    shape = RoundedCornerShape(12),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = MaterialTheme.colorScheme.primary,
                        containerColor =MaterialTheme.colorScheme.background
                    ),

                    ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Register",
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))


            }
        },
        containerColor = Color(0xFF8F221F)
    ) { padding ->
        Box(modifier = Modifier.padding(padding)){
           /* Image(
                painter = painterResource(id = R.drawable.ic_loan),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,

                )*/
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Welcome to Equity Mobile",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineLarge
                )

            }
        }

    }

}

@Composable
fun AuthScreenPreview() {
    EquityMobileTheme {
        AuthScreen(
            onSignUp = { /*TODO*/ }) {

        }

    }

}