package com.dev.chacha.auth.presentation.forgot_password

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.fingerprint_screen.FingerPrintScreen

@Composable
fun ForgotPasswordScreen(
    onClick: () -> Unit,
    onLoginClick: () -> Unit
) {

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