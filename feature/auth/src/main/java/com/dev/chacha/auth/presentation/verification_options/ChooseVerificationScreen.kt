package com.dev.chacha.auth.presentation.verification_options

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.navigation.AuthScreen
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.components.TwoButtonsVertical


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseVerificationScreen(
    navController: NavController
) {
    var selectedOption by remember { mutableStateOf<VerificationOption?>(null) }

    Scaffold(
        topBar = {
            StandardToolbar(
                showBackArrow = true,
                title = "Verify",
            )
        },
        bottomBar = {
            selectedOption?.let {
                TwoButtonsVertical(
                    topButtonText = "I've changed my contact details",
                    bottomButtonText = "Confirm",
                    onTopButtonClick = { navController.navigate(AuthScreen.SmsCodeVerification.route) },
                    onBottomButtonClick = { navController.navigate(AuthScreen.SmsCodeVerification.route)},
                    enableBottomButton = it.equals(true),
                    showTopButton = true
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
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.verify_header),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = stringResource(id = R.string.select_hint),
                        maxLines = 2,
                        style = MaterialTheme.typography.titleSmall

                    )


                    // ... rest of your code ...
                    verificationOptions.forEach { option ->
                        VerificationOptionItemList(
                            icon = option.icon,
                            title = option.title,
                            descriptionValue = option.description,
                            selected = selectedOption == option // Check if this option is selected
                        ) {
                            selectedOption = option // Set the selected option when clicked
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                }

            }
        }
}


@Composable
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        ChooseVerificationScreen(rememberNavController())
    }

}
