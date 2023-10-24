package com.dev.chacha.transaction.presentation.buy_airtime.bottom_sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.transaction.presentation.buy_airtime.BuyAirtimeComponent
import com.dev.chacha.transaction.presentation.buy_airtime.BuyAirtimeUiEvent
import com.dev.chacha.transaction.presentation.buy_airtime.BuyAirtimeViewModel
import com.dev.chacha.transaction.presentation.buy_airtime.simOperatorsList
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityTextField
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import kotlinx.coroutines.launch

@Composable
fun BuyAirtimeBottomSheet() {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()
    val buyAirtimeViewModel: BuyAirtimeViewModel = viewModel()
    val uiState by buyAirtimeViewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolbar(
            title = stringResource(id = R.string.buy_for_someone_new),
            showBackArrow = true,
            )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = "Please select an operator",
                style = MaterialTheme.typography.titleLarge
            )

            EquityTextField(
                value = buyAirtimeViewModel.mobileCountry?.fullName ?: "",
                onValueChange = {
                    buyAirtimeViewModel.onBuyAirtimeEvent(
                        BuyAirtimeUiEvent.OnCountryFullNameSelected(
                            it
                        )
                    )
                    buyAirtimeViewModel.onBuyAirtimeEvent(BuyAirtimeUiEvent.OnCountryCodeSelected(it))
                    buyAirtimeViewModel.onBuyAirtimeEvent(BuyAirtimeUiEvent.OnCountryNameSelected(it))
                    isSheetOpen = true
                    currentBottomSheet = TransactionBottomSheetType.BUY_AIRTIME_COUNTRY_SHEET
                },
                readOnly = true,
                title = stringResource(id = R.string.select_country),
                hint = stringResource(id = R.string.country),
                showDefaultTrailingIcon = true
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(simOperatorsList.size) { index ->
                    BuyAirtimeComponent(
                        buyAirtimeItem = simOperatorsList[index],
                        onSelectedOperator = {
                             buyAirtimeViewModel.onBuyAirtimeEvent(BuyAirtimeUiEvent.OnSelectSimOperator(it.simOperator))

                        },
                    )
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