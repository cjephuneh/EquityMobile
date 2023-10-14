package com.dev.chacha.more.presentation.reset_pin_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.ConditionRow
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPinScreen(
    navController: NavController

    ) {

    val resetPinViewModel: ResetPinViewModel = viewModel()
    val pinError by resetPinViewModel.pinError.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Change Pin",
                showBackArrow = true,
                onNavigateBack = {navController.navigateUp()}

            )
        },
        bottomBar = {

            EquityButton(
                onClick = { /*TODO*/ },
                text = "Confirm",
                enable = true
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Text(
                        text = "Change your pin",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = stringResource(id = R.string.make_sure_your_pin_easy),
                    )


                    AppTextField(
                        title = stringResource(R.string.current_pin),
                        text = resetPinViewModel.currentPIN,
                        onValueChange = resetPinViewModel::changeCurrentPIN,
                        hint = stringResource(id = R.string.enter_current_pin),
                        keyboardType = KeyboardType.NumberPassword,
                        error = resetPinViewModel.currentPINError.value,
                        isPasswordVisible = resetPinViewModel.showPIN.value,
                        onPasswordToggleClick = {
                            resetPinViewModel.setShowPIN(it)
                        },
                        isError = !pinError.successful,
                        maxLength = 4
                    )


                    AppTextField(
                        title = stringResource(R.string.new_pin),
                        text = resetPinViewModel.newPIN,
                        onValueChange = resetPinViewModel::changeNewPIN,
                        hint = stringResource(id = R.string.enter_new_pin),
                        keyboardType = KeyboardType.NumberPassword,
                        error = resetPinViewModel.newPINError.value,
                        isPasswordVisible = resetPinViewModel.showPIN.value,
                        onPasswordToggleClick = {
                            resetPinViewModel.setShowPIN(it)
                        },
                        maxLength = 4

                    )


                    AppTextField(
                        title = stringResource(id = R.string.confirm_pin),
                        text = resetPinViewModel.confirmNewPIN,
                        onValueChange = resetPinViewModel::changeConfirmPIN,
                        hint = stringResource(id = R.string.confirm_pin),
                        keyboardType = KeyboardType.NumberPassword,
                        error = resetPinViewModel.confirmPINError.value,
                        isPasswordVisible = resetPinViewModel.showPIN.value,
                        onPasswordToggleClick = {
                            resetPinViewModel.setShowPIN(it)
                        },
                        isError = !pinError.hasValidPIN,
                        maxLength = 4

                    )


                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {

                            Image(
                                painter = painterResource(id = R.drawable.outline_verified_user_24),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp),
                                contentScale = ContentScale.Crop,
                                colorFilter = ColorFilter.tint(color = Color.White)
                            )
                            Text(
                                text = stringResource(id = R.string.pinValidate_header),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp)
                            )

                        }



                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            ConditionRow(
                                condition = stringResource(id = R.string.passwordMatch),
                                check = pinError.hasMinimum
                            )
                            ConditionRow(
                                condition = stringResource(id = R.string.validateSequence),
                                check = pinError.hasNoSequences
                            )
                            ConditionRow(
                                condition = stringResource(id = R.string.validate_repetetive),
                                check = pinError.hasNoRepetitiveDigits
                            )
                            ConditionRow(
                                condition = stringResource(id = R.string.don_t_use_a_previous_or_old_pin),
                                check = pinError.hasValidConfirmPIN
                            )
                            ConditionRow(
                                condition = stringResource(id = R.string.passwordMatch),
                                check = pinError.hasValidConfirmPIN
                            )
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
        ResetPinScreen(
            navController = rememberNavController()
        )
    }

}
