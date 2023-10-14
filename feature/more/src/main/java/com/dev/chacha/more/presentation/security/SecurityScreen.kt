package com.dev.chacha.more.presentation.security

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.biometric.BiometricManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.data.BiometricUiEvent
import com.dev.chacha.data.BiometricViewModel
import com.dev.chacha.more.presentation.MoreScreenNavigation
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun SecurityScreen(
    navController: NavController,
) {

    val biometricViewModel : BiometricViewModel = hiltViewModel()

    val biometricUiState by biometricViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current


    val executor = remember { ContextCompat.getMainExecutor(context) }
    val biometricPrompt = androidx.biometric.BiometricPrompt(
        context as FragmentActivity,
        executor,
        object : androidx.biometric.BiometricPrompt.AuthenticationCallback() {

            override fun onAuthenticationSucceeded(result: androidx.biometric.BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                biometricViewModel.onEvent(BiometricUiEvent.EnableBiometricToggled(true))
                // Handle authentication success here
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
            StandardToolbar(
                title = "Security Questions",
                showForwardArrow = true,
                showBackArrow = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                contentAlignment = Alignment.TopStart
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(securityItemOptions) { securityItem ->
                        MoreVerticalItem(
                            drawable = securityItem.drawable,
                            title = securityItem.title,
                            subtitle = securityItem.subtitle,
                            onClick = { securityItemOption ->
                                when (securityItemOption) {
                                    R.string.change_password_title -> {
                                        navController.navigate(MoreScreenNavigation.ChangePassword.route)
                                    }

                                    R.string.manage_your_pin_title -> {
                                        navController.navigate(MoreScreenNavigation.ChangePin.route)
                                    }

                                    R.string.manage_security_question_title -> {
                                        navController.navigate(MoreScreenNavigation.ManageSecurityQuestion.route)
                                    }
                                }
                            }
                        )
                    }
                    item {
                        MoreVerticalItem(
                            drawable = R.drawable.fingerprint,
                            title = R.string.enable_touch_title,
                            subtitle = R.string.enable_touch_subtitle,
                            showSwitcher = true,
                            onClick = {

                            },
                            onCheckChange = {
                                if (!biometricUiState.isBiometricEnabled) {
                                    biometricPrompt.authenticate(promptInfo)

                                } else {
                                    // The user disabled biometric authentication
                                    // Update the SharedPreferences to store the status
                                    biometricViewModel.onEvent(BiometricUiEvent.EnableBiometricToggled(false))
                                }
                            },
                            isChecked = biometricUiState.isBiometricEnabled?: false
                        )
                    }
                    item {
                        MoreVerticalItem(
                            drawable = R.drawable.devices,
                            title = R.string.manage_your_devices_title,
                            subtitle = R.string.manage_your_devices_subtitle,
                            onClick = {
                                navController.navigate(MoreScreenNavigation.ManageDevices.route)
                            }
                        )
                    }
                }
            }
        }
    }
}

data class SecurityItem(
    @StringRes val title: Int,
    @StringRes val subtitle: Int? = null,
    @DrawableRes val drawable: Int
)

private val securityItemOptions = listOf(
    SecurityItem(
        drawable = R.drawable.outline_password_24,
        title = R.string.change_password_title,
        subtitle = R.string.change_password_description,
    ),
    SecurityItem(
        drawable = R.drawable.outline_lock_24,
        title = R.string.manage_your_pin_title,
        subtitle = R.string.manage_your_pin_subtitle,
    ),
    SecurityItem(
        drawable = R.drawable.baseline_verified_user_24,
        title = R.string.manage_security_question_title,
        subtitle = R.string.manage_security_question_subtitle,
    ),

    )


@Composable
fun ManageSecurityQnPreview() {
    EquityMobileTheme {
        SecurityScreen(
            rememberNavController()
        )
    }
}