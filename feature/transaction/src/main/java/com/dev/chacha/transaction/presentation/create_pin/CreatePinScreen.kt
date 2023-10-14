package com.dev.chacha.transaction.presentation.create_pin

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.ConditionRow
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePinScreen(
    createPinViewModel: CreatePinViewModel = viewModel()
) {
    val pinError by createPinViewModel.pinError.collectAsStateWithLifecycle()
    Scaffold(topBar = {
        StandardToolbar(
            showBackArrow = true,
            title = "Create Pin",
            showForwardArrow = true,
        )
    },
        bottomBar = {
            EquityButton(
                onClick = { /*TODO*/ },
                text = stringResource(id = R.string.set_pin)
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)

        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.createPin_header),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = stringResource(id = R.string.createPin_hint),
                        maxLines = 1,
                        style = MaterialTheme.typography.titleSmall

                    )
                    AppTextField(
                        text = createPinViewModel.pin,
                        title = stringResource(id = R.string.pin_title),
                        onValueChange = createPinViewModel::changePin,
                        hint = stringResource(id = R.string.pin_hint),
                        keyboardType = KeyboardType.NumberPassword,
                        error = createPinViewModel.passwordError.value,
                        isPasswordVisible = createPinViewModel.showPassword.value,
                        onPasswordToggleClick = {
                            createPinViewModel.setShowPassword(it)
                        },
                        isError = !pinError.successful,
                        maxLength = 4
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    AppTextField(
                        title = stringResource(id = R.string.confirm_pin),
                        text = createPinViewModel.confirmPIN,
                        onValueChange = createPinViewModel::changeConfirmPIN,
                        hint = stringResource(id = R.string.confirm_pin_hint),
                        keyboardType = KeyboardType.NumberPassword,
                        error = createPinViewModel.passwordError.value,
                        isPasswordVisible = createPinViewModel.showPassword.value,
                        onPasswordToggleClick = {
                            createPinViewModel.setShowPassword(it)
                        },
                        isError = !pinError.hasValidConfirmPIN,
                        maxLength = 4

                    )
                    Spacer(modifier = Modifier.height(40.dp))

                    /*
                    Pin Validation Ui
                     */
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 0.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,

                            ) {

                            Image(
                                painter = painterResource(id = R.drawable.outline_verified_user_24),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                contentScale = ContentScale.Crop,
                                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground)
                            )
                            Text(
                                text = stringResource(id = R.string.pinValidate_header),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                style = MaterialTheme.typography.titleMedium
                            )

                        }
                        Spacer(modifier = Modifier.height(10.dp))


                        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                            ConditionRow(
                                condition = "Minimum 4 digits",
                                check = pinError.hasMinimum
                            )
                            ConditionRow(
                                condition = "Valid PIN format",
                                check = pinError.hasValidPIN
                            )
                            ConditionRow(
                                condition = "PINs match",
                                check = pinError.hasValidConfirmPIN
                            )
                            ConditionRow(
                                condition = stringResource(com.dev.chacha.util.R.string.validateSequence),
                                check = pinError.hasNoSequences
                            )
                            ConditionRow(
                                condition = stringResource(com.dev.chacha.util.R.string.validateRepetetive),
                                check = pinError.hasNoRepetitiveDigits
                            )
                        }

                    }


                }

            }

        }

    }
}


@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        CreatePinScreen(createPinViewModel = CreatePinViewModel())
    }

}
