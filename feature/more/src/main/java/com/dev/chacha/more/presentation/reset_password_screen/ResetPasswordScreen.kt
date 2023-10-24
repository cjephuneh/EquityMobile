package com.dev.chacha.more.presentation.reset_password_screen

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
fun ResetPasswordScreen(
    navController: NavController,
    resetPasswordViewModel: ResetPasswordViewModel = viewModel(),
) {
    val passwordError by resetPasswordViewModel.passwordError.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Reset Password",
                showForwardArrow = true,
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = "Reset your password",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = stringResource(id = R.string.createPassword_hint),
                )

                AppTextField(
                    text = resetPasswordViewModel.currentPassword,
                    onValueChange = resetPasswordViewModel::changeCurrentPassword,
                    hint = stringResource(id = R.string.current_password),
                    keyboardType = KeyboardType.Password,
                    isPasswordVisible = resetPasswordViewModel.showPassword.value,
                    onPasswordToggleClick = {
                        resetPasswordViewModel.setShowPassword(it)
                    },
                    isError = !passwordError.successful
                )


                AppTextField(
                    text = resetPasswordViewModel.newPassword,
                    onValueChange = resetPasswordViewModel::changePassword,
                    hint = stringResource(id = R.string.new_password),
                    keyboardType = KeyboardType.Password,
                    isPasswordVisible = resetPasswordViewModel.showPassword.value,
                    onPasswordToggleClick = {
                        resetPasswordViewModel.setShowPassword(it)
                    },
                    isError = !passwordError.hasPasswordMatch
                )


                AppTextField(
                    text = resetPasswordViewModel.confirmNewPassword,
                    onValueChange = resetPasswordViewModel::changeConfirmNewPassword,
                    hint = stringResource(id = R.string.confirm_new_password),
                    keyboardType = KeyboardType.Password,
                    isPasswordVisible = resetPasswordViewModel.showPassword.value,
                    onPasswordToggleClick = {
                        resetPasswordViewModel.setShowPassword(it)
                    })

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
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
                            modifier = Modifier.size(50.dp),
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )
                        Text(
                            text = stringResource(id = R.string.validate_header),
                        )

                    }

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

                        ConditionRow(
                            condition = stringResource(id = R.string.validateLetter),
                            check = passwordError.hasCapitalizedLetter
                        )
                        ConditionRow(
                            condition = stringResource(id = R.string.validateCharLong),
                            check = passwordError.hasMinimum
                        )
                        ConditionRow(
                            condition = stringResource(id = R.string.validate_specialChar),
                            check = passwordError.hasSpecialCharacter
                        )
                        ConditionRow(
                            condition = stringResource(id = R.string.passwordMatch),
                            check = passwordError.hasPasswordMatch
                        )
                    }


                }


            }

        }
    }


}

@Composable
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        ResetPasswordScreen(
            resetPasswordViewModel = ResetPasswordViewModel(),
            navController = rememberNavController()
        )
    }

}
