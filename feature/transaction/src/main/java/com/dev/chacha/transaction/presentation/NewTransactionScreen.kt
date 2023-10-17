package com.dev.chacha.transaction.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.chacha.transaction.presentation.component.SchedulePaymentCard
import com.dev.chacha.transaction.presentation.component.TransactCardItem
import com.dev.chacha.transaction.presentation.transaction.TransactViewModel
import com.dev.chacha.transaction.presentation.transaction.TransactionHeader
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.util.Graph.ANOTHER_BANK_ROUTE
import com.dev.chacha.util.Graph.ANOTHER_EQUITY_ACCOUNT_ROUTE
import com.dev.chacha.util.Graph.BUY_AIRTIME_ROUTE
import com.dev.chacha.util.Graph.BUY_GOODS_ROUTE
import com.dev.chacha.util.Graph.MOBILE_WALLET_ROUTE
import com.dev.chacha.util.Graph.OWN_EQUITY_ACCOUNT_ROUTE
import com.dev.chacha.util.Graph.PAYPAL_ROUTE
import com.dev.chacha.util.Graph.PAY_BILL_ROUTE
import com.dev.chacha.util.Graph.PAY_TO_CARD_ROUTE
import com.dev.chacha.util.Graph.WESTERN_UNION_ROUTE
import com.dev.chacha.util.Graph.WITHDRAW_CASH_AGENT_ROUTE


@Composable
fun NewTransactionScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val transactViewModel: TransactViewModel = viewModel()

    var selectedType by remember { mutableStateOf("All") } // Initialize with "All" as the default selection

    val filterTypes = listOf("All", "Send Money", "Pay With Equity", "Buy", "Withdraw Money", "Remittance")



    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Transact",
                showForwardArrow = true
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            val filteredItems = when (selectedType) {
                "Send Money" -> sendMoneyList
                "Pay With Equity" -> payWithEquityList
                "Buy" -> buyAirtime
                "Withdraw Money" -> withdrawCashList
                "Remittance" -> remittanceItemList
                else -> sendMoneyList + payWithEquityList + buyAirtime + withdrawCashList + remittanceItemList
            }

          /*  FilterChips(
                filterTypes = filterTypes,
                selectedType = selectedType,
                onTypeSelected = { type ->
                    selectedType = type
                }
            )*/


            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                item(span = { GridItemSpan(3) }) {

                    // create here filter for all,paywithEquity,sendMoney,buyAirtime,remittance,withdrawCash
                }

                item(span = { GridItemSpan(3) }) {
                    TransactionHeader(
                        onAddFavouriteClick = {
                            transactViewModel.setShowDialogState(true)
                        }
                    )
                }

                item(span = { GridItemSpan(3) }) {
                    SchedulePaymentCard()
                }

                item(span = { GridItemSpan(3) }) {
                    Text(
                        text = "Send Money",
                        fontWeight = FontWeight.Bold

                    )

                }
                items(sendMoneyList.size) { index ->
                    TransactCardItem(
                        text = sendMoneyList[index].text,
                        icon = sendMoneyList[index].icon,
                        onClick = { sendMoneyOption ->
                            when (sendMoneyOption) {
                                R.string.own_equity_account -> {navController.navigate(OWN_EQUITY_ACCOUNT_ROUTE)}
                                R.string.another_equity_account -> {navController.navigate(ANOTHER_EQUITY_ACCOUNT_ROUTE)}
                                R.string.pay_top_up -> {navController.navigate(PAY_TO_CARD_ROUTE)}
                                R.string.mobile_wallet -> {navController.navigate(MOBILE_WALLET_ROUTE)}
                                R.string.another_bank -> {navController.navigate(ANOTHER_BANK_ROUTE)}
                            }

                        }
                    )
                }



                item(span = { GridItemSpan(3) }) {

                    Text(
                        text = "Pay With Equity",
                        fontWeight = FontWeight.Bold

                    )
                }
                items(payWithEquityList.size) { index ->
                    TransactCardItem(
                        text = payWithEquityList[index].text,
                        icon = payWithEquityList[index].icon,
                        onClick = { payWithEquityOption ->
                            when (payWithEquityOption) {
                                R.string.pay_bill -> {navController.navigate(PAY_BILL_ROUTE)}
                                R.string.buy_goods -> { navController.navigate(BUY_GOODS_ROUTE)}

                            }

                        }
                    )

                }

                item(span = { GridItemSpan(3) }) {
                    Text(
                        text = "Buy",
                        fontWeight = FontWeight.Bold
                    )
                }
                items(buyAirtime.size) {index->
                    TransactCardItem(
                        text = buyAirtime[index].text,
                        icon = buyAirtime[index].icon,
                        onClick = {  buyAirtimeOption ->
                            when (buyAirtimeOption) {
                                R.string.buy_airtime -> {navController.navigate(BUY_AIRTIME_ROUTE)}
                            }

                        }
                    )

                }

                item(span = { GridItemSpan(3) }) {

                    Text(
                        text = "Withdraw Money",
                        fontWeight = FontWeight.Bold

                    )
                }
                items(withdrawCashList.size) { index ->
                    TransactCardItem(
                        text = withdrawCashList[index].text,
                        icon = withdrawCashList[index].icon,
                        onClick = { withdrawOption ->
                            when (withdrawOption) {
                                R.string.agent -> {navController.navigate(WITHDRAW_CASH_AGENT_ROUTE)}
                            }
                        }
                    )

                }

                item(span = { GridItemSpan(3) }) {

                    Text(
                        text = "Remittance",
                        fontWeight = FontWeight.Bold
                    )
                }
                items(remittanceItemList.size) { index ->
                    TransactCardItem(
                        text = remittanceItemList[index].text,
                        icon = remittanceItemList[index].icon,
                        onClick = { remittanceOption ->
                            when (remittanceOption) {
                                R.string.paypal_hint -> {navController.navigate(PAYPAL_ROUTE)}
                                R.string.western_union_hint -> {navController.navigate(WESTERN_UNION_ROUTE)}

                            }
                        },
                        showDrawableColorTint = true
                    )

                }

                item(span = { GridItemSpan(3) }) {
                    Spacer(modifier = Modifier.height(12.dp))
                }

            }

        }

    }

}


data class SendMoneyItem(
    @StringRes val text: Int,
    @DrawableRes val icon: Int,
)

private val sendMoneyList = listOf(
    SendMoneyItem(
        text = R.string.own_equity_account,
        icon = R.drawable.sync_alt,
    ),
    SendMoneyItem(
        text = R.string.another_equity_account,
        icon = R.drawable.ic_input_24,
    ),
    SendMoneyItem(
        text = R.string.pay_top_up,
        icon = R.drawable.account_balance,
    ),
    SendMoneyItem(
        text = R.string.mobile_wallet,
        icon = R.drawable.outline_send_to_mobile_24,
    ),
    SendMoneyItem(
        text = R.string.another_bank,
        icon = R.drawable.account_balance,
    )

)

private val remittanceItemList = listOf(
    SendMoneyItem(
        text = R.string.paypal_hint,
        icon = R.drawable.paypal_icons,
    ),
    SendMoneyItem(
        text = R.string.western_union_hint,
        icon = R.drawable.western_union_icon,
    )

)

private val withdrawCashList = listOf(
    SendMoneyItem(
        text = R.string.agent,
        icon = R.drawable.leaderboard,
    ),
)

private val payWithEquityList = listOf(
    SendMoneyItem(
        text = R.string.pay_bill,
        icon = R.drawable.receipt,
    ),
    SendMoneyItem(
        text = R.string.buy_goods,
        icon = R.drawable.trolley,
    )
)

private val buyAirtime = listOf(
    SendMoneyItem(
        text = R.string.buy_airtime,
        icon = R.drawable.outline_phone_android,
    ),

)


@Composable
fun FilterChips(
    filterTypes: List<String>,
    selectedType: String,
    onTypeSelected: (String) -> Unit
) {
    // Create filter chips here
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        filterTypes.forEach { type ->
            FilterChip(
                text = type,
                selected = type == selectedType,
                onSelectedChange = {
                    onTypeSelected(type)
                }
            )
        }
    }
}

@Composable
fun FilterChip(text: String, selected: Boolean, onSelectedChange: (Boolean) -> Unit) {
    // Customize the appearance of your filter chip, e.g., use a Chip or Button composable
    Button(
        onClick = { onSelectedChange(!selected) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color.Gray else Color.LightGray,
        )
    ) {
        Text(text = text)
    }
}



