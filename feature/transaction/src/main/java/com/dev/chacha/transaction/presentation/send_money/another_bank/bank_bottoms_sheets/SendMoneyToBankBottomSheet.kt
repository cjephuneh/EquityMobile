package com.dev.chacha.transaction.presentation.send_money.another_bank.bank_bottoms_sheets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.transaction.presentation.component.SendToBankItem
import com.dev.chacha.transaction.presentation.component.bankList
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTopBar
import com.dev.chacha.ui.common.components.EquityDivider
import com.dev.chacha.ui.common.components.EquityTextField
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet

@Composable
@Preview
fun SendMoneyToBankBottomSheet() {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        StandardToolbar(
            title = stringResource(id = R.string.send_to_a_bank_account),
            showBackArrow = true,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = "Please select the recipient's bank",
                style = MaterialTheme.typography.titleLarge
            )

            EquityTextField(
                value = "Kenya",
                onValueChange = {

                },
                readOnly = true,
                title = stringResource(id = R.string.select_country),
                hint = stringResource(id = R.string.country),
            )

            AppTopBar(
                title = "",
                initialValue = "",
                onSearchParamChange = {},
                showSearchBar = true,
                searchHint = stringResource(id = R.string.search_for_bank)
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(bankList.size) { index ->
                    SendToBankItem(
                        bank = bankList[index],
                        selectedBank = {

                        },

                        )

                    if(index< bankList.size - 1){
                        EquityDivider()
                    }
                }

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