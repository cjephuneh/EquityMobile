package com.dev.chacha.transaction.presentation.send_money.mobile_money

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

@SuppressLint("NewApi")
@Composable
fun MobileWalletScreen(navController: NavController) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()
    val mobileMoneyViewModel : MobileMoneyViewModel = viewModel()

    val mobileState by mobileMoneyViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Send mobile money",
                showBackArrow = true,
                onNavigateBack = {navController.navigateUp()}
            )
        },
        bottomBar = {
            EquityButton(
                onClick = { /*TODO*/ },
                text = "Send money"
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
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
                value = "",
                onValueChange = {
                    isSheetOpen = true
                    currentBottomSheet = TransactionBottomSheetType.MOBILE_MONEY_FIRST_SCREEN
                },
                title = "Send to",
                hint = "Select the recipient"
            )

            AmountCurrencyTextField(
                leftTextFieldValue = "",
                rightTextFieldValue = "",
                leftTextFieldPlaceholderHint = "KSH",
                rightTextFieldPlaceholderHint = stringResource(R.string.enter_amount),
                onLeftValueChange = {
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
                    onClose = {
                        coroutineScope.launch {
                            isSheetOpen = false
                        }

                    }
                )
            }
        }
    }

}