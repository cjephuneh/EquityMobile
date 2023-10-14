package com.dev.chacha.loans.presentation.pay_loan

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dev.chacha.loans.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.loans.presentation.modalsheet_layout.LoanBottomSheetType
import com.dev.chacha.ui.common.components.AccountTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.PayToTextField
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayLoanScreen(
    onPayLoan: () -> Unit,
    navController: NavController
) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: LoanBottomSheetType? by remember { mutableStateOf(null) }
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Pay loan",
                showBackArrow = true,
                onNavigateBack = {navController.navigateUp()}
            )
        },
        bottomBar = {

            EquityButton(
                onClick = { /*TODO*/ },
                text = "Make the payment"
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Please enter the loan payment details",
                style = MaterialTheme.typography.titleLarge
            )
            AccountTextField(
                value = "",
                onValueChange = {
                    isSheetOpen = true
                    currentBottomSheet = LoanBottomSheetType.ACCOUNT_BALANCE
                },
                title = "Pay from",
                accountNumber = "12345678",
                hint = "Available balance is 52.80"
            )

            PayToTextField(
                value = "",
                onValueChange = {
                    isSheetOpen = true
                    currentBottomSheet = LoanBottomSheetType.SELECT_LOAN
                },
                title = "To",
                hint = "Select loan to pay"
            )

            PayToTextField(
                value = "",
                onValueChange = {
                    isSheetOpen = true
                    currentBottomSheet = LoanBottomSheetType.AMOUNT_LOAN
                },
                title = "Amount",
                hint = "Select an amount"
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
