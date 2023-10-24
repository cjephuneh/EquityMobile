package com.dev.chacha.transaction.presentation.transaction

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.chacha.transaction.presentation.TransactViewModel
import com.dev.chacha.transaction.presentation.component.SchedulePaymentCard
import com.dev.chacha.transaction.presentation.component.TransactCardItem
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityDivider
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
fun AllTransactionScreen(
    navController: NavController
) {
    val transactViewModel: TransactViewModel = viewModel()
    val context = LocalContext.current

    val newTransactUiState by transactViewModel.newTransactUiState.collectAsStateWithLifecycle()
    val isRemittanceCategory = newTransactUiState.selectedCategory == "Remittance"

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item(span = { GridItemSpan(3) }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "What would you like to do?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }


        item(span = { GridItemSpan(3) }) {
            ScrollableTabRow(
                selectedTabIndex = newTransactUiState.categories.indexOf(newTransactUiState.selectedCategory),
                containerColor = Color.White,
                contentColor = Color.Black,
                edgePadding = 0.dp,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(
                            tabPositions[newTransactUiState
                                .categories.indexOf(newTransactUiState.selectedCategory)]
                        ),
                        color = Color.Transparent
                    )
                },
                divider = {
                    Divider(color = Color.Transparent)
                }
            ) {
                newTransactUiState.categories.forEachIndexed { index, category ->
                    Tab(
                        selected = newTransactUiState.selectedCategory == category,
                        onClick = {
                            transactViewModel.selectCategory(category)
                        },
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        OutlinedButton(
                            onClick = { transactViewModel.selectCategory(category) },
                            border = BorderStroke(
                                1.dp,
                                color = if (newTransactUiState.selectedCategory == category) MaterialTheme.colorScheme.primary else Color.Gray
                            ),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Text(
                                text = category,
                                color = if (newTransactUiState.selectedCategory == category) MaterialTheme.colorScheme.primary else Color.Gray,
                            )
                        }

                    }
                }
            }
        }

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
            EquityDivider()

        }

        item(span = { GridItemSpan(3) }) {
            SchedulePaymentCard()
        }

        item(span = { GridItemSpan(3) }) {
            Text(
                text = "Send Money",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge

            )

        }
        items(sendMoneyList.size) { index ->
            TransactCardItem(
                text = sendMoneyList[index].text,
                icon = sendMoneyList[index].icon,
                onClick = { sendMoneyOption ->
                    when (sendMoneyOption) {
                        R.string.own_equity_account -> {
                            navController.navigate(OWN_EQUITY_ACCOUNT_ROUTE)
                        }

                        R.string.another_equity_account -> {
                            navController.navigate(ANOTHER_EQUITY_ACCOUNT_ROUTE)
                        }

                        R.string.pay_top_up -> {
                            navController.navigate(PAY_TO_CARD_ROUTE)
                        }

                        R.string.mobile_wallet -> {
                            navController.navigate(MOBILE_WALLET_ROUTE)
                        }

                        R.string.another_bank -> {
                            navController.navigate(ANOTHER_BANK_ROUTE)
                        }
                    }

                }
            )
        }



        item(span = { GridItemSpan(3) }) {

            Text(
                text = "Pay With Equity",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge


            )
        }
        items(payWithEquityList.size) { index ->
            TransactCardItem(
                text = payWithEquityList[index].text,
                icon = payWithEquityList[index].icon,
                onClick = { payWithEquityOption ->
                    when (payWithEquityOption) {
                        R.string.pay_bill -> {
                            navController.navigate(PAY_BILL_ROUTE)
                        }

                        R.string.buy_goods -> {
                            navController.navigate(BUY_GOODS_ROUTE)
                        }

                    }

                }
            )

        }

        item(span = { GridItemSpan(3) }) {
            Text(
                text = "Buy",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge

            )
        }
        items(buyAirtime.size) { index ->
            TransactCardItem(
                text = buyAirtime[index].text,
                icon = buyAirtime[index].icon,
                onClick = { buyAirtimeOption ->
                    when (buyAirtimeOption) {
                        R.string.buy_airtime -> {
                            navController.navigate(BUY_AIRTIME_ROUTE)
                        }
                    }

                }
            )

        }

        item(span = { GridItemSpan(3) }) {

            Text(
                text = "Withdraw Money",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge


            )
        }
        items(withdrawCashList.size) { index ->
            TransactCardItem(
                text = withdrawCashList[index].text,
                icon = withdrawCashList[index].icon,
                onClick = { withdrawOption ->
                    when (withdrawOption) {
                        R.string.agent -> {
                            navController.navigate(WITHDRAW_CASH_AGENT_ROUTE)
                        }
                    }
                }
            )

        }

        item(span = { GridItemSpan(3) }) {

            Text(
                text = "Remittance",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge

            )
        }
        items(remittanceItemList.size) { index ->
            TransactCardItem(
                text = remittanceItemList[index].text,
                icon = remittanceItemList[index].icon,
                onClick = { remittanceOption ->
                    when (remittanceOption) {
                        R.string.paypal_hint -> {
                            navController.navigate(PAYPAL_ROUTE)
                        }

                        R.string.western_union_hint -> {
                            navController.navigate(WESTERN_UNION_ROUTE)
                        }

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




