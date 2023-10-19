package com.dev.chacha.transaction.presentation.transaction

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.transaction.presentation.TransactViewModel
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.transaction.presentation.component.CreatePinAlertDialog
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionScreen(
    transactViewModel: TransactViewModel = viewModel(),
    navigateToSchedulePayment: () -> Unit,
    navigateToOwnEquityAccount: () -> Unit,
    navigateToAnotherEquityAccount: () -> Unit,
    navigateToPayWithCard: () -> Unit,
    navigateToMobileWallet: () -> Unit,
    navigateToAnotherBank: () -> Unit,
    navigateToPayBill: () -> Unit,
    navigateToBuyGoods: () -> Unit,
    navigateToBuyAirtime: () -> Unit,
    navigateToWithdrawCashAgent: () -> Unit,
    navigateToPayPal: () -> Unit,
    navigateToWesternUnion: () -> Unit,
    navigateToCreatePin: ()->Unit
) {
    val shouldShowDialog = transactViewModel.shouldShowDialog.value
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        StandardToolbar(
            title = "Transact",
            showForwardArrow = true
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center
        ) {

            if (shouldShowDialog) {
                CreatePinAlertDialog(
                    onDismissClick = { transactViewModel.setShowDialogState(!transactViewModel.shouldShowDialog.value) },
                    onClick = { navigateToCreatePin() }
                )
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    TransactionHeader(
                        onAddFavouriteClick = {
                            transactViewModel.setShowDialogState(true)
                        }
                    )
                }
                item { FullDivider() }

                item {
                    SchedulePaymentItem(
                        onClickSchedulePayment = {navigateToSchedulePayment()}
                    )
                }
                item { FullDivider() }
                item {
                    SendMoneyItem(
                        onNavigateToOwnEquityAccount = {navigateToOwnEquityAccount()},
                        onNavigateToAnotherEquityAccount = {navigateToAnotherEquityAccount()},
                        onNavigateToPayWithCard = {navigateToPayWithCard()},
                        onNavigateToMobileWallet = {navigateToMobileWallet()},
                        onNavigateToAnotherBank = {navigateToAnotherBank()}
                    )
                }
                item { FullDivider() }
                item {
                    PayWithEquity(
                        onClickPayBill = {navigateToPayBill()},
                        onClickBuyGoods = {navigateToBuyGoods()}
                    )
                }
                item { FullDivider() }
                item {
                    BuyItem(
                        onClickBuyAirtime = {navigateToBuyAirtime()}
                    )
                }
                item { FullDivider() }
                item {
                    Withdraw(
                        onWithCashAgent = {navigateToWithdrawCashAgent()}
                    )
                }
                item { FullDivider() }
                item {
                    ThirdPartyTransactions(
                        onClickPayPal = { navigateToPayPal() },
                        onClickWesternUnion = {
                            isSheetOpen = true
                            currentBottomSheet = TransactionBottomSheetType.WESTERN_UNION_SCREEN
                        }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
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


@Composable
fun TransactionHeader(onAddFavouriteClick:()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(8.dp)),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.outline
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.favorite),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = R.string.favourite),
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(MutableInteractionSource(), null) {
                            onAddFavouriteClick()
                        },
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Text(
                        text = stringResource(id = R.string.add_favourite),
                        textAlign = TextAlign.End,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

            }


        }

    }

}

@Composable
fun SchedulePaymentItem(
    onClickSchedulePayment: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Schedule",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        TransactionTitle(
            drawable = R.drawable.money_icon,
            title = R.string.schedule_payment,
            onItemClick = { onClickSchedulePayment() }
        )
    }
}

@Composable
fun ThirdPartyTransactions(
    onClickPayPal: () -> Unit,
    onClickWesternUnion: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Third party transactions",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        TransactionTitle(
            drawable = R.drawable.paypal_icons,
            title = R.string.paypal_hint,
            onItemClick = { onClickPayPal() },
            showDrawableColorTint = true

        )
        MiddleDivider()
        TransactionTitle(
            drawable = R.drawable.western_union_icon,
            title = R.string.western_union_hint,
            onItemClick = { onClickWesternUnion() },
            showDrawableColorTint = true

        )
    }

}

@Composable
fun SendMoneyItem(
    onNavigateToOwnEquityAccount: () -> Unit,
    onNavigateToAnotherEquityAccount: () -> Unit,
    onNavigateToPayWithCard: () -> Unit,
    onNavigateToMobileWallet: () -> Unit,
    onNavigateToAnotherBank: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Send Money",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(16.dp))
        TransactionTitle(
            drawable = R.drawable.sync_alt,
            title = R.string.own_equity_account,
            onItemClick = {
                onNavigateToOwnEquityAccount()
            }
        )
        MiddleDivider()
        TransactionTitle(
            drawable = R.drawable.ic_input_24,
            title = R.string.another_equity_account,
            onItemClick = {
                onNavigateToAnotherEquityAccount()
            }
        )
        MiddleDivider()
        TransactionItemRow(
            drawable = R.drawable.account_balance,
            title = R.string.pay_top_up,
            onItemClick = {
                onNavigateToPayWithCard()
            }
        )
        MiddleDivider()
        TransactionItemRow(
            drawable = R.drawable.account_balance_wallet,
            title = R.string.mobile_wallet,
            subtitle = R.string.send_to_mobile,
            onItemClick = {
                onNavigateToMobileWallet()
            }
        )
        MiddleDivider()
        TransactionTitle(
            drawable = R.drawable.ic_creditcard,
            title = R.string.another_bank,
            onItemClick = {
                onNavigateToAnotherBank()
            }
        )

    }


}


@Composable
fun PayWithEquity(
    onClickBuyGoods: () -> Unit,
    onClickPayBill: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Pay with Equity",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        TransactionTitle(
            drawable = R.drawable.receipt,
            title = R.string.pay_bill,
            onItemClick = {
                onClickPayBill()
            }
        )
        MiddleDivider()
        TransactionTitle(
            drawable = R.drawable.trolley,
            title = R.string.buy_goods,
            onItemClick = {
                onClickBuyGoods()
            }
        )
    }


}


@Composable
fun BuyItem(
    onClickBuyAirtime: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Buy",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        TransactionTitle(
            drawable = R.drawable.outline_phone_android,
            title = R.string.buy_airtime,
            onItemClick = {
                onClickBuyAirtime()
            }
        )

    }
}

@Composable
fun Withdraw(onWithCashAgent: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Withdraw cash",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        TransactionTitle(
            drawable = R.drawable.leaderboard,
            title = R.string.agent,
            onItemClick = {
                onWithCashAgent()
            },
        )

    }
}

@Composable
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        TransactionScreen(
            navigateToSchedulePayment = {},
            navigateToOwnEquityAccount = {},
            navigateToAnotherEquityAccount = {},
            navigateToPayWithCard = {},
            navigateToMobileWallet = {},
            navigateToAnotherBank = {},
            navigateToPayBill = {},
            navigateToBuyGoods = {},
            navigateToBuyAirtime = {},
            navigateToWithdrawCashAgent = {},
            navigateToPayPal = {},
            navigateToWesternUnion = {},
            navigateToCreatePin = {}
        )
    }

}
