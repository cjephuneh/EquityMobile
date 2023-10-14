package com.dev.chacha.transaction.presentation.send_money.another_bank.bank_bottoms_sheets

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTopBar
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet

@Composable
@Preview
fun SendToBankFirstScreen() {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    Column(
        modifier = Modifier
            .fillMaxHeight(.85f)
    ) {
        StandardToolbar(
            title = "Send to ",
            showBackArrow = true,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {


            Text(
                text = "Who are you sending money to",
                style = MaterialTheme.typography.titleLarge
            )

            AppTopBar(
                title = "",
                initialValue = "",
                onSearchParamChange = {},
                showSearchBar = true,
            )

            MoreVerticalItem(
                title = R.string.send_to_a_bank_account,
                drawable = R.drawable.account_balance,
                onClick = {
                    isSheetOpen = true
                    currentBottomSheet = TransactionBottomSheetType.SEND_MONEY_TO_BANK
                }
            )
            MoreVerticalItem(
                title = R.string.send_to_phone_linked_account,
                drawable = R.drawable.ic_input_24,
                onClick = {
                    isSheetOpen = true
                    currentBottomSheet = TransactionBottomSheetType.SEND_MONEY_TO_PHONE_LINKED_ACCOUNT
                }
            )

            Column {
                Text(
                    text = "Favorites",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "0 Favourite Found",
                    style = MaterialTheme.typography.titleSmall

                )
            }

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