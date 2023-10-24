package com.dev.chacha.transaction.presentation.send_money.another_equity_account

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AccountTextField
import com.dev.chacha.ui.common.components.AmountCurrencyTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.PayToTextField
import com.dev.chacha.ui.common.components.PaymentReasonTextField
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet

@SuppressLint("NewApi")
@Composable
fun AnotherEquityAccountScreen(
    navController: NavController
) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val equityAccountViewModel: EquityAccountViewModel = viewModel()
    val uiState by equityAccountViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Send to an Equity account",
                showBackArrow = true,
                onNavigateBack = {navController.navigateUp()}
            )
        },
        bottomBar = {

            EquityButton(
                onClick = { /*TODO*/ },
                text = "Send Money"
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Please enter the payment details",
                style = MaterialTheme.typography.titleLarge
            )
            AccountTextField(
                value = "",
                onValueChange = {
                    isSheetOpen = true
                    currentBottomSheet = TransactionBottomSheetType.ACCOUNT_BALANCE
                },
                title = "Send from",
                accountNumber = "12345678",
                hint = "Available balance is 52.80"
            )

            PayToTextField(
                value = uiState.mobileNumber,
                onValueChange = {
                    equityAccountViewModel.onEquityAccountEvent(EquityAccountUiEvent.OnMobileNumberChanged(it))

                    isSheetOpen = true
                   currentBottomSheet = TransactionBottomSheetType.EQUITY_ACCOUNT_FIRST_BOTTOM_SHEET
                },
                title = "Send to",
                hint = "Select a recipient",
                readOnly = true
            )

            AmountCurrencyTextField(
                leftTextFieldTitleHint = "currency",
                leftTextFieldValue = uiState.country?.code?:"",
                rightTextFieldValue = "",
                leftTextFieldPlaceholderHint = "KSH",
                rightTextFieldPlaceholderHint = stringResource(R.string.enter_amount),
                onLeftValueChange = {
                    equityAccountViewModel.onEquityAccountEvent(EquityAccountUiEvent.OnCountryCodeSelected(it))
                    isSheetOpen = true
                    currentBottomSheet = TransactionBottomSheetType.CURRENCY_BOTTOM_SHEET
                },
                onRightValueChange = {}
            )
            PaymentReasonTextField(
                value = "",
                onValueChange = {},
                title = stringResource(R.string.payment_reason),
                hint = stringResource(R.string.optional)
            )

        }
    }

    if (isSheetOpen) {
        EquityModalSheet(
            onDismissRequest = {
                isSheetOpen = false
            },
        ) {
            currentBottomSheet?.let {
                EquityModalSheetLayout(
                    bottomSheetType = it,
                    onClose = {}
                )
            }
        }
    }


}