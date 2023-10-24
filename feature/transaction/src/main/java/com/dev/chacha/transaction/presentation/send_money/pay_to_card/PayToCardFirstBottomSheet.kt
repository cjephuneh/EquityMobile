package com.dev.chacha.transaction.presentation.send_money.pay_to_card

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactPhone
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.transaction.presentation.send_money.mobile_money.MobileMoneyUiEvent
import com.dev.chacha.transaction.presentation.send_money.mobile_money.MobileMoneyViewModel
import com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_third_sheet.ContactListViewModel
import com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_third_sheet.ContactUiEvent
import com.dev.chacha.ui.common.components.AmountCurrencyTextField
import com.dev.chacha.ui.common.components.EquityDivider
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.launch

@Composable
fun PayToCardFirstBottomSheet() {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val contactViewModel: ContactListViewModel = viewModel()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val mobileMoneyViewModel: MobileMoneyViewModel = viewModel()
    val mobileState by mobileMoneyViewModel.uiState.collectAsStateWithLifecycle()




    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            title = "Pay to ",
            onNavigateBack = {
                coroutineScope.launch {
                    isSheetOpen = false
                }
            },
            navigationCloseIcons = Icons.Outlined.Close
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Please select a card",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 16.dp),
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