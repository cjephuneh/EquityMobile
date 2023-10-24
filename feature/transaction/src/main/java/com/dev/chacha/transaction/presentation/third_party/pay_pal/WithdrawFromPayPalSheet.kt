package com.dev.chacha.transaction.presentation.third_party.pay_pal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.navigation.NavController
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AmountCurrencyTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.EquityTextField
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet

@Composable
fun WithdrawFromPayPalSheet(
    navController: NavController,
    onNavigateBack:()->Unit
) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Withdraw from paypal",
                showBackArrow = true,
                onNavigateBack = {onNavigateBack()}
            )
        },
        bottomBar = {
            EquityButton(
                onClick = { /*TODO*/ },
                text = stringResource(id = R.string.withdraw_cash)
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(16.dp),
        ) {

            Text(
                text = "Please enter the withdrawal details",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            EquityTextField(
                title = "Withdraw from",
                hint = "stevechacha4@gmail.com",
                onValueChange = {},
                showDefaultTrailingIcon = true
            )
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(text = "Send to")
                Text(text = "STEPHEN CHACHA MARWA")
                Text(text = "1234567890 SBA")
            }

            Spacer(modifier = Modifier.height(16.dp))


            AmountCurrencyTextField(
                leftTextFieldTitleHint = "currency",
                leftTextFieldValue = "",
                rightTextFieldValue = "",
                leftTextFieldPlaceholderHint = "EURO",
                rightTextFieldPlaceholderHint = stringResource(R.string.enter_amount),
                onLeftValueChange = {
                    isSheetOpen = true
                    currentBottomSheet = TransactionBottomSheetType.CURRENCY_BOTTOM_SHEET
                },
                onRightValueChange = {}
            )
            Column {
                Text(text = "Exchange rate 1 EUR - 151.51 KES")
                Text(text = "Converted amount 151.51 KES")
            }

        }
    }


    if (isSheetOpen) {
        EquityModalSheet(
            onDismissRequest = {
                isSheetOpen = false
            },
            modalSheetHeight = Modifier.fillMaxHeight()
        ) {
            currentBottomSheet?.let {
                EquityModalSheetLayout(
                    bottomSheetType = it,
                    onClose = {},
                    navController = navController
                )
            }
        }
    }


}