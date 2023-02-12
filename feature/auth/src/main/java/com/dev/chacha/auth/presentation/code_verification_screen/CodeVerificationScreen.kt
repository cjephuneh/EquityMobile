package com.dev.chacha.auth.presentation.code_verification_screen


import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.auth_screen.AuthScreen
import com.dev.chacha.ui.common.theme.primaryPink
import com.dev.chacha.ui.common.components.StandardToolbar

import com.dev.chacha.ui.R


@Composable
fun CodeVerificationScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                showBackArrow = true,
                title = "Verify"
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
        {
            Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "We have sent a verification code to your " +
                                    "registered 25474******13",
                            textAlign = TextAlign.Center
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            OutlinedButton(
                                onClick = {
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 8.dp, end = 8.dp
                                    ),
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
                                    text = "Need help?",
                                    fontSize = 16.sp,
                                    color = primaryPink
                                )
                            }
                            Spacer(modifier = Modifier.height(45.dp))
                        }
                    }
                }
            }
        }

}


@Composable
@Preview("Light Mode",showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun CodeVerificationPreview() {
    EquityMobileTheme {
        CodeVerificationScreen()

    }

}