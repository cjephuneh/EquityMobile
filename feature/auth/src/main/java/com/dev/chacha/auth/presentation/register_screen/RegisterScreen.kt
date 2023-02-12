package com.dev.chacha.auth.presentation.register_screen

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.fingerprint_screen.FingerPrintScreen
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardTextField
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun RegisterScreen(
    onClick: () -> Unit,
    onLoginClick: () -> Unit,
    viewModel: RegisterViewModel
) {
    Scaffold(topBar = {
        StandardToolbar(
            title = "Register",
            showForwardArrow = true,
            showBackArrow = true
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val rememberMeState = viewModel.rememberMeState.value

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Create your profile",
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = stringResource(id = R.string.signin),
                        maxLines = 2,
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp)

                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Country",
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                    )

                    StandardTextField(text = viewModel.usernameText.value,
                        onValueChange = {
                            viewModel.setUsernameText(it)
                        },
                        keyboardType = KeyboardType.Text,
                        error = viewModel.usernameError.value,
                        hint = stringResource(id = R.string.country),
                        modifier = Modifier.clickable {

                        }

                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Account Number",
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)

                    )
                    StandardTextField(
                        text = viewModel.usernameText.value,
                        onValueChange = {
                            viewModel.setUsernameText(it)
                        },
                        keyboardType = KeyboardType.Number,
                        error = viewModel.usernameError.value,
                        hint = stringResource(id = R.string.account_hint),
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "ID number",
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)

                    )
                    StandardTextField(
                        text = viewModel.usernameText.value,
                        onValueChange = {
                            viewModel.setUsernameText(it)
                        },
                        keyboardType = KeyboardType.Number,
                        error = viewModel.usernameError.value,
                        hint = stringResource(id = R.string.idnumber_hint),
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = rememberMeState,
                                onCheckedChange = {
                                    viewModel.setRememberMe(it)
                                },
                            )
                            Text(
                                text = "I agree to the terms and privacy policy",
                                fontSize = 12.sp,
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                            ),
                            shape = RoundedCornerShape(8.dp)

                        ) {
                            Text(
                                text = "Create profile + add accounts",
                                modifier = Modifier.padding(10.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(30.dp))

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
        RegisterScreen(
            onClick = { /*TODO*/ },
            onLoginClick = { /*TODO*/ },
            viewModel = RegisterViewModel()
        )
    }

}



