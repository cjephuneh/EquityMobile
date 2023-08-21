package com.dev.chacha.auth.presentation.forgot_password

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardToolbar

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
            ForgotPasswordButton(
                onRegisterClick = {},
                onContinueClick = {}
            )
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
fun ForgotPasswordButton(
    onRegisterClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {


        OutlinedButton(
            onClick = { onRegisterClick() },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colorScheme.primary,
                containerColor = Color.Transparent,
            ),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(8)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center,
                text = "Register",
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = { onContinueClick() },
            shape = RoundedCornerShape(8),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onBackground,
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = ContentAlpha.medium)
            ),

            ) {
            Text(
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center,
                text = "Continue",
                fontSize = 16.sp
            )
        }

    }
}


@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun ForgotPasswordScreenPreview() {
    EquityMobileTheme {
        ForgotPasswordScreen(onClick = { /*TODO*/ }) {

        }
    }

}