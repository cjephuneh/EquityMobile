package com.dev.chacha.auth.presentation.create_password

import android.content.res.Configuration
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.my_validate.ConditionRow
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardToolbar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePasswordScreen(
    onClickAction: () -> Unit,
    createPasswordViewModel: CreatePasswordViewModel = viewModel()
) {
    val passwordError by createPasswordViewModel.passwordError.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            StandardToolbar(title = stringResource(id = R.string.create_password))
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(24.dp)
            ) {
                EquityButton(
                    onClick = { onClickAction()},
                    text = stringResource(id = R.string.confirm_pass),
                    enable = true

                )
            }
        }
    ) { paddingValues ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal =24.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.createPasswd_header),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = stringResource(id = R.string.createPassword_hint),
                        maxLines = 1,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    AppTextField(
                        text = createPasswordViewModel.password,
                        onValueChange =createPasswordViewModel::changePassword,
                        hint = stringResource(id = R.string.password_hint),
                        keyboardType = KeyboardType.Password,
                        isError = !passwordError.successful,
                        isPasswordVisible = createPasswordViewModel.showPassword.value,
                        onPasswordToggleClick = {
                            createPasswordViewModel.setShowPassword(it)
                        },
                        title = stringResource(id = R.string.password_title),
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AppTextField(
                        text = createPasswordViewModel.confirmPassword,
                        onValueChange = createPasswordViewModel::changeConfirmPassword,
                        hint = stringResource(id = R.string.re_enter_password_hint),
                        keyboardType = KeyboardType.Password,
                        isError = !passwordError.hasPasswordMatch,
                        isPasswordVisible = createPasswordViewModel.showPassword.value,
                        onPasswordToggleClick = {
                            createPasswordViewModel.setShowPassword(it)
                        },
                        title = stringResource(id = R.string.confirm_password),
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,

                            ) {
                            Image(
                                painter =
                                painterResource(id = R.drawable.outline_verified_user_24),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                contentScale = ContentScale.Crop,
                                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground)
                            )
                            Text(
                                text = stringResource(id = R.string.validate_header),
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            ConditionRow(condition = stringResource(id = R.string.validateLetter), check = passwordError.hasCapitalizedLetter)
                            ConditionRow(condition = stringResource(id = R.string.validateCharLong), check = passwordError.hasMinimum)
                            ConditionRow(condition = stringResource(id = R.string.validate_specialChar), check = passwordError.hasSpecialCharacter)
                            ConditionRow(condition = stringResource(id = R.string.passwordMatch), check = passwordError.hasPasswordMatch)
                        }

                    }


                }


            }


        }

}


@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun CreatePasswordPreview() {
    EquityMobileTheme {
        CreatePasswordScreen(onClickAction = { /*TODO*/ })

    }

}