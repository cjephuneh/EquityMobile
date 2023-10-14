package com.dev.chacha.transaction.presentation.send_money.another_equity_account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.transaction.presentation.send_money.mobile_money.MobileMoneyViewModel
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTopBar
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import kotlinx.coroutines.launch

@Composable
fun EquityAccountFirstBottomSheet() {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolbar(
            title = "Send to ",
            navigationCloseIcons = Icons.Outlined.Close,
            onNavigateBack = {
                coroutineScope.launch {
                    isSheetOpen = false
                }
            },
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {


            Text(
                text = "Who are you sending money to?",
                style = MaterialTheme.typography.titleLarge
            )

            AppTopBar(
                title = "",
                initialValue = "",
                onSearchParamChange = {},
                showSearchBar = true,
                searchHint = "Search for recipient"
            )

            MoreVerticalItem(
                title = R.string.send_to_someone_new,
                drawable = R.drawable.outline_person_add_24,
                onClick = {
                    isSheetOpen = true
                    currentBottomSheet = TransactionBottomSheetType.EQUITY_ACCOUNT_SECOND_BOTTOM_SHEET
                }
            )


            Column {
                Text(
                    text = "Favorites",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "0 Favourite found",
                    style = MaterialTheme.typography.titleSmall

                )
                Text(
                    text = "Recents",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "0 Recents found",
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