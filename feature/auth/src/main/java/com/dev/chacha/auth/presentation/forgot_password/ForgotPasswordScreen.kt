package com.dev.chacha.auth.presentation.forgot_password

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.components.TwoButtonsHorizontal

@Composable
fun ForgotPasswordScreen(
    onClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StandardToolbar(
                title = "Forgot Password",
                showBackArrow = true
            )
        },
        bottomBar = {
            TwoButtonsHorizontal(
                leftButtonText = "Register",
                rightButtonText = "Continue" ,
                onLeftButtonClick = { /*TODO*/ },
                onRightButtonClick = { /*TODO*/ })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(R.string.have_you_forgotten_your_password),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(R.string.forgot_password_description),
                style = MaterialTheme.typography.titleSmall

            )
            AppTextField(
                title = stringResource(id = R.string.email_or_mobile_number),
                onValueChange = { /*TODO*/ },
                hint = stringResource(id = R.string.email_or_mobile_number),
                keyboardType = KeyboardType.Email
            )


        }

    }


}


@Composable
fun ForgotPasswordScreenPreview() {
    EquityMobileTheme {
        ForgotPasswordScreen(onClick = { /*TODO*/ }) {

        }
    }

}