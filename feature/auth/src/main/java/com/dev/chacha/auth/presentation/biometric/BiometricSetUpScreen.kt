package com.dev.chacha.auth.presentation.biometric

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.AuthScreen
import com.dev.chacha.data.BiometricUiEvent
import com.dev.chacha.data.BiometricViewModel
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.TwoButtonsVertical

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun BiometricSetUpScreen(navController: NavController) {
    val context = LocalContext.current

    val viewModel: BiometricViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val isBiometricEnabled by viewModel.uiState.collectAsStateWithLifecycle()


    val biometricManager = remember { BiometricManager.from(context) }
    val isBiometricAvailable = remember {
        biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
    }
    when (isBiometricAvailable) {
        BiometricManager.BIOMETRIC_SUCCESS -> {
            // Biometric features are available
        }

        BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
            // No biometric features available on this device
        }

        BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
            // Biometric features are currently unavailable.
        }

        BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> {
            // Biometric features available but a security vulnerability has been discovered
        }

        BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> {
            // Biometric features are currently unavailable because the specified options are incompatible with the current Android version..
        }

        BiometricManager.BIOMETRIC_STATUS_UNKNOWN -> {
            // Unable to determine whether the user can authenticate using biometrics
        }

        BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
            // The user can't authenticate because no biometric or device credential is enrolled.
        }
    }

    val executor = remember { ContextCompat.getMainExecutor(context) }
    val biometricPrompt = androidx.biometric.BiometricPrompt(
        context as FragmentActivity,
        executor,
        object : androidx.biometric.BiometricPrompt.AuthenticationCallback() {

            @RequiresApi(Build.VERSION_CODES.R)
            override fun onAuthenticationSucceeded(result: androidx.biometric.BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                viewModel.onEvent(BiometricUiEvent.EnableBiometricToggled(true))
                navController.navigate(AuthScreen.MainLogin.route)
                // handle authentication success here
            }

        }
    )


    val promptInfo = androidx.biometric.BiometricPrompt.PromptInfo.Builder()
        .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
        .setTitle("Equity mobile")
        .setSubtitle("Touch ID is required to sign")
        .setNegativeButtonText("CANCEL")
        .build()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.set_up_fingerprint_id))
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }

                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )

        },
        bottomBar = {

            TwoButtonsVertical(
                topButtonText = "Skip this step",
                bottomButtonText = "Ok, set up now",
                onTopButtonClick = { navController.navigate(AuthScreen.MainLogin.route) },
                onBottomButtonClick = {
                    if (isBiometricEnabled.isBiometricEnabled) {
                        // Biometric authentication is already enabled, show a message or take action
                        // For example:
                        // showSnackbar("Biometric authentication is already enabled")
                    } else {
                        // Biometric authentication is not enabled, you can start the setup process
                        biometricPrompt.authenticate(promptInfo)
                    }


                },
                enableBottomButton = true,
                showTopButton = true
            )


        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painter = painterResource(id = R.drawable.fingerprint),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Sign in with Fingerprint ID",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "You can use Fingerprint ID to sign in",
                style = MaterialTheme.typography.titleSmall

            )

        }

    }


}


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        BiometricSetUpScreen(rememberNavController())
    }

}
