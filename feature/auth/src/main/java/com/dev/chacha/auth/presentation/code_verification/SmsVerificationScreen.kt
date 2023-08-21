package com.dev.chacha.auth.presentation.code_verification


import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.register.CountriesBottomSheets
import com.dev.chacha.extensions.formatContact
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.base.AppViewModel
import com.dev.chacha.ui.common.components.EquityOutlinedButton
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryPink


@SuppressLint("UnrememberedMutableState", "NewApi")
@Composable
fun SmsVerificationScreen(navController: NavController, appViewModel:AppViewModel = viewModel()) {

    val userContact = "254746656813"
    val otpValue by remember { mutableStateOf("") }
    val enableButton = derivedStateOf {
        otpValue.length ==6
    }
    Scaffold(
        topBar = {
            StandardToolbar(
                showBackArrow = true,
                title = "Verify"
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                EquityOutlinedButton(
                    onClick = { /*TODO*/ },
                    text = "Need help?",
                     enable = enableButton.value
                )
            }
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
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
                    text = "We have sent a verification code to your registered ${formatContact(userContact)}",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "Please enter the code",
                    style = MaterialTheme.typography.titleSmall

                )
//                Error
                Text(
                    text = "There is Bug Needs to be fixed for bottom sheet though it allows to autofill",
                    color = Color.Red
                )
                OTPInputField(
                    otpLength = 6,
                    onOtpChange = {},
                    navController = navController
                )

            }
        }

    }


}





@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun CodeVerificationPreview() {
    EquityMobileTheme {
        SmsVerificationScreen(rememberNavController())

    }

}