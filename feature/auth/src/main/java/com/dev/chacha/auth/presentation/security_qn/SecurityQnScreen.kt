package com.dev.chacha.auth.presentation.security_qn

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.dev.chacha.auth.presentation.components.AppBasicTextField
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecurityQnScreen(
    viewModel: SecurityQnViewModel

) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Security questions",
                showBackArrow = true,
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .navigationBarsPadding()
            ) {
                EquityButton(
                    onClick = { /*TODO*/ },
                    text = "Confirm",
                )

            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {
            var expanded by remember { mutableStateOf(false) }

            var mSelectedText by remember { mutableStateOf("") }

//        // Up Icon when expanded and down icon when collapsed
            val icon = if (expanded)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.KeyboardArrowDown

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyColumn {
                        item {
                            Text(
                                text = "Create security_screen questions"
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "Make the answers easy to remember"
                            )
                            Spacer(modifier = Modifier.height(16.dp))

                            AppBasicTextField(
                                text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = "Select a question",
                                error = viewModel.passwordError.value,
                                title = "Question",
                                trailingIcon = {

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onGloballyPositioned { coordinates ->
                                    }
                            )

                            Spacer(modifier = Modifier.height(8.dp))
                            AppTextField(
                                text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = stringResource(id = R.string.password_hint),
                                keyboardType = KeyboardType.Password,
                                error = viewModel.passwordError.value,
                                isPasswordVisible = viewModel.showPassword.value,
                                onPasswordToggleClick = {
                                    viewModel.setShowPassword(it)
                                },
                                title = "Answer"
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            AppBasicTextField(
                                text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = "Select a question",
                                error = viewModel.passwordError.value,
                                title = "Question",
                                trailingIcon = {

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onGloballyPositioned { coordinates ->
                                    }
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            AppTextField(text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = stringResource(id = R.string.password_hint),
                                keyboardType = KeyboardType.Password,
                                error = viewModel.passwordError.value,
                                isPasswordVisible = viewModel.showPassword.value,
                                onPasswordToggleClick = {
                                    viewModel.setShowPassword(it)
                                },
                                title = "Answer"

                            )
                            Spacer(modifier = Modifier.height(8.dp))


                            AppBasicTextField(
                                text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = "Select a question",
                                error = viewModel.passwordError.value,
                                title = "Question",
                                trailingIcon = {

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onGloballyPositioned { coordinates ->
                                    }
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            AppTextField(text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = stringResource(id = R.string.password_hint),
                                keyboardType = KeyboardType.Password,
                                error = viewModel.passwordError.value,
                                isPasswordVisible = viewModel.showPassword.value,
                                onPasswordToggleClick = {
                                    viewModel.setShowPassword(it)
                                },
                                title = "Answer"

                            )

                        }
                    }

                }
            }

        }

    }
}




