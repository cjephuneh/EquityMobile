package com.dev.chacha.auth.presentation.pin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.auth.presentation.my_validate.ConditionRow
import com.dev.chacha.util.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PinScreen(
    pinViewModel: PinScreenViewModel = viewModel()
) {
    val pinError by pinViewModel.pinError.collectAsStateWithLifecycle()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = pinViewModel.pin,
            onValueChange = pinViewModel::changePassword,
            visualTransformation = PasswordVisualTransformation(),
            isError = !pinError.successful
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = pinViewModel.confirmPIN,
            onValueChange = pinViewModel::changeConfirmPIN,
            visualTransformation = PasswordVisualTransformation(),
            isError = !pinError.hasValidConfirmPIN
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            ConditionRow(condition = "Minimum 4 digits", check = pinError.hasMinimum)
            ConditionRow(condition = "Valid PIN format", check = pinError.hasValidPIN)
            ConditionRow(condition = "PINs match", check = pinError.hasValidConfirmPIN)
            ConditionRow(condition = stringResource(R.string.validateSequence),
                check = !pinError.hasNoSequences)
            ConditionRow(condition = stringResource(R.string.validateRepetetive),
                check = !pinError.hasNoRepetitiveDigits)
        }
    }
}
