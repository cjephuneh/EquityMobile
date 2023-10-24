package com.dev.chacha.auth.presentation.main_login

import androidx.biometric.BiometricManager
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.chacha.data.BiometricViewModel
import com.dev.chacha.extensions.getInitials
import com.dev.chacha.extensions.greeting
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.util.Graph

@Composable
fun MainLoginScreen(
    navController: NavController,
    mainLoginViewModel: MainLoginViewModel = viewModel()
) {

    val biometricViewModel: BiometricViewModel = hiltViewModel()
    val biometricUiState by biometricViewModel.uiState.collectAsStateWithLifecycle()

    val context = LocalContext.current

    val myName = "Stephen Chacha"


    val textState = remember { mutableStateOf("") }

    val executor = remember { ContextCompat.getMainExecutor(context) }
    val biometricPrompt = androidx.biometric.BiometricPrompt(
        context as FragmentActivity,
        executor,
        object : androidx.biometric.BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                // handle authentication error here
            }


            override fun onAuthenticationSucceeded(result: androidx.biometric.BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                navController.navigate(Graph.HOME_SCREEN_ROUTE)
                // handle authentication success here
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                // handle authentication failure here
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
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                if (biometricUiState.isBiometricEnabled) {
                    // Add a Composable button here for biometric authentication
                    OutlinedButton(
                        onClick = {
                            biometricPrompt.authenticate(promptInfo)
                        },
                        modifier = Modifier.height(50.dp).fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        enabled = true,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),

                        ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                painter = painterResource(id = R.drawable.fingerprint),
                                contentDescription = stringResource(R.string.sign_in_with_touch_id),
                                modifier = Modifier.size(24.dp),
                                tint = MaterialTheme.colorScheme.primary,
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = stringResource(R.string.sign_in_with_touch_id),
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.SemiBold
                            )

                        }

                    }
                } else{
                    Text(text = " ")
                }

                Button(
                    onClick = {
                        navController.navigate(Graph.HOME_SCREEN_ROUTE)
                    },
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Red,
                        containerColor = if (textState.value.isNotEmpty()){
                            MaterialTheme.colorScheme.primary
                        } else {
                            Color.DarkGray
                        }
                    ),
                    shape = RoundedCornerShape(8.dp),
                    enabled = textState.value.isNotEmpty()

                ) {

                    Text(
                        text = "Let me in",
                        color = MaterialTheme.colorScheme.background,
                    )
                }

            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 16.dp, end = 16.dp, top = 50.dp, bottom = 18.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    .size(64.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = getInitials(myName),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(Modifier.height(16.dp))

            Text(
                text = "$greeting, Stephen",
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(Modifier.height(20.dp))
            
            AppTextField(
                title = "Password",
                text = textState.value,
                onValueChange = { textState.value = it },
                modifier = Modifier.fillMaxWidth(),
                hint = stringResource(id = R.string.enter_password_to_sign_in),
                keyboardType = KeyboardType.Password,
                error = mainLoginViewModel.passwordError.value,
                isPasswordVisible = mainLoginViewModel.showPassword.value,
                onPasswordToggleClick = {
                    mainLoginViewModel.setShowPassword(it)
                }
            )
            Spacer(Modifier.height(16.dp))

            Text(
                text = "Forgot your password?",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall
            )

        }

    }

}