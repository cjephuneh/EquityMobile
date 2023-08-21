package com.dev.chacha.auth.presentation.register

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.AuthScreen
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.base.AppViewModel
import com.dev.chacha.ui.common.base.PathState
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardToolbar

@SuppressLint("NewApi")
@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel = viewModel(),
    onClick: () -> Unit,
    onLoginClick: () -> Unit,
    navController: NavController,
    appViewModel: AppViewModel = viewModel()
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StandardToolbar(
                title = stringResource(id = R.string.register),
                showForwardArrow = true,
                showBackArrow = true
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                EquityButton(
                    onClick = {
                        navController.navigate(AuthScreen.CreatePassword.route)
                    },
                    text = stringResource(R.string.create_profile_add_accounts),
                    enable = true
                )

                Spacer(modifier = Modifier.height(16.dp))

            }

        }
    ) { paddingValues ->

        val rememberMeState = registerViewModel.rememberMeState.value

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.create_your_profile),
                    modifier = Modifier,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                AppTextField(
                    text = registerViewModel.usernameText.value,
                    onValueChange = {
                        registerViewModel.setUsernameText(it)
                    },
                    keyboardType = KeyboardType.Text,
                    error = registerViewModel.usernameError.value,
                    hint = stringResource(id = R.string.country),
                    title = stringResource(id = R.string.select_country),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDownward,
                            contentDescription = null,
                            modifier = Modifier.clickable(MutableInteractionSource(), null) {
                                appViewModel.openSheet(PathState(COUNTRY_BOTTOMSHEET))
                            }
                        )
                    },
                    onClick = {
                        appViewModel.openSheet(PathState(COUNTRY_BOTTOMSHEET))

                    }

                )

                AppTextField(
                    text = registerViewModel.usernameText.value,
                    onValueChange = {
                        registerViewModel.setUsernameText(it)
                    },
                    keyboardType = KeyboardType.Number,
                    error = registerViewModel.usernameError.value,
                    hint = stringResource(id = R.string.account_number_hint),
                    title = stringResource(id = R.string.account_number_title),
                )


                AppTextField(
                    text = registerViewModel.usernameText.value,
                    onValueChange = {
                        registerViewModel.setUsernameText(it)
                    },
                    keyboardType = KeyboardType.Number,
                    error = registerViewModel.usernameError.value,
                    hint = stringResource(id = R.string.id_number_hint),
                    title = stringResource(id = R.string.id_number_title),
                )



                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = rememberMeState,
                        onCheckedChange = {
                            registerViewModel.setRememberMe(it)
                        },
                    )

                    ClickableColoredTermsAndPolicy(navController)


                }
            }
        }

    }

    CountriesBottomSheets(appViewModel)

}

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        RegisterScreen(
            onClick = { /*TODO*/ },
            onLoginClick = { /*TODO*/ },
            registerViewModel = RegisterViewModel(),
            navController = rememberNavController()
        )
    }

}

const val COUNTRY_BOTTOMSHEET = "counties bottomsheet"





