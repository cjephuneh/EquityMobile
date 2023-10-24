package com.dev.chacha.auth.presentation.register

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.navigation.AuthScreen
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.base.AppViewModel
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.AppTopBar
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.EquityTextField
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import kotlinx.coroutines.launch

@SuppressLint("NewApi")
@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel = viewModel(),
    onClick: () -> Unit,
    onLoginClick: () -> Unit,
    navController: NavController,
    appViewModel: AppViewModel = viewModel()
) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StandardToolbar(
                title = stringResource(id = R.string.register),
                showForwardArrow = true,
                showBackArrow = true,
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        },
        bottomBar = {

            EquityButton(
                onClick = {
                    navController.navigate(AuthScreen.CreatePassword.route)
                },
                text = stringResource(R.string.create_profile_add_accounts),
                enable = true
            )
            
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
                EquityTextField(
                    value = registerViewModel.mobileCountry?.fullName ?: "",
                    onValueChange = {
                        isSheetOpen = true
                        registerViewModel.onRegisterEvent(RegisterUiEvent.OnCountryFullNameSelected(it))
                        registerViewModel.onRegisterEvent(RegisterUiEvent.OnCountryCodeSelected(it))
                        registerViewModel.onRegisterEvent(RegisterUiEvent.OnCountryNameSelected(it))
                    },
                    readOnly = true,
                    title = stringResource(id = R.string.select_country),
                    hint = stringResource(id = R.string.country),
                    enabled = false,
                    showDefaultTrailingIcon = true
                )




                AppTextField(
                    text = registerViewModel.accountNumber.value,
                    onValueChange = {
                        registerViewModel.setAccountNumber(it)
                    },
                    keyboardType = KeyboardType.Number,
                    error = registerViewModel.accountNumberError.value,
                    hint = stringResource(id = R.string.account_number_hint),
                    title = stringResource(id = R.string.account_number_title),
                )


                AppTextField(
                    text = registerViewModel.idNumberText.value,
                    onValueChange = {
                        registerViewModel.setIdNumberText(it)
                    },
                    keyboardType = KeyboardType.Number,
                    error = registerViewModel.idNumberError.value,
                    hint = stringResource(id = R.string.id_number_hint),
                    title = stringResource(id = R.string.id_number_title),
                )

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 3.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = rememberMeState,
                        onCheckedChange = {
                            registerViewModel.setRememberMe(it)
                        },
                    )

                    ClickableColoredTermsAndPolicy(
                       onClick = {

                       }
                    )

                }
            }
        }

    }


    if (isSheetOpen) {
        EquityModalSheet(
            onDismissRequest = {
                isSheetOpen = false
            },
        ) {
            val selectedCountry = registerViewModel.mobileCountry
            Box(modifier = Modifier.fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),

                    ) {
                    AppTopBar(
                        title = "Country",
                        initialValue = "",
                        onSearchParamChange = {},
                        showSearchBar = true,
                        searchHint = stringResource(id = R.string.search_for_country),
                        showTopBar = true
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(registerViewModel.countriesList) { country ->
                            CountrySelectionListItems(
                                country = country,
                                selectedCountry = selectedCountry == country,
                                onCountrySelected = {
                                    registerViewModel.mobileCountry = it
                                    registerViewModel.mobileCountryCode = it.code
                                    coroutineScope.launch {
                                        isSheetOpen = false
                                    }

                                }
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(100.dp))
                        }
                    }
                }

            }
        }
    }

}

@Composable
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

const val COUNTRY_BOTTOM_SHEET = "counties bottom-sheet"





