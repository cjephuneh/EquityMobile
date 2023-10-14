package com.dev.chacha.transaction.presentation.send_money.mobile_money.send_money_operator_sheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.transaction.presentation.buy_airtime.BuyAirtimeViewModel
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityDivider
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import kotlinx.coroutines.launch

@Composable
fun SendMoneyOperators() {
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
            title = stringResource(id = R.string.send_to_someone_new),
            navigationCloseIcons = Icons.Outlined.Close,
            onNavigateBack = {
                coroutineScope.launch {
                    isSheetOpen = false
                }
            }
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


            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(sendMoneyOperatorsList.size) { index ->
                    SendMoneyOperatorItem(
                        buyAirtimeItem = sendMoneyOperatorsList[index],
                        onSelectedOperator = {

                          isSheetOpen = true
                          currentBottomSheet = TransactionBottomSheetType.MOBILE_MONEY_SECOND_SCREEN
                        },

                    )
                    if (index< sendMoneyOperatorsList.size -1){
                        EquityDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 56.dp, end = 16.dp),
                            thickness = 1.dp
                        )
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


@Composable
fun SendMoneyOperatorItem(
    buyAirtimeItem: SendMoneyOperators,
    selected: Boolean = false,
    onSelectedOperator: (SendMoneyOperators) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(MutableInteractionSource(), null) {
                onSelectedOperator(buyAirtimeItem)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Transparent, CircleShape)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(
                        id = when (buyAirtimeItem.simOperator) {
                            "mpesa" -> R.drawable.cd
                            "airtel" -> R.drawable.ke
                            else -> R.drawable.paypal_icons // A placeholder image
                        }
                    ),
                    contentDescription = buyAirtimeItem.simOperator,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }


            Text(
                text = buyAirtimeItem.simOperator,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))


            RadioButton(
                selected = selected,
                onClick = { onSelectedOperator(buyAirtimeItem) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary
                )
            )
        }

    }

}

data class SendMoneyOperators(
    val country: String,
    val simOperator: String,
)

val sendMoneyOperatorsList = listOf(
    SendMoneyOperators(
        country = "Kenya",
        simOperator = "mpesa",
    ),
    SendMoneyOperators(
        country = "Kenya",
        simOperator = "airtel",
    )

)