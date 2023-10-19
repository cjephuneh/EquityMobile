package com.dev.chacha.transaction.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.chacha.transaction.presentation.component.SchedulePaymentCard
import com.dev.chacha.transaction.presentation.component.TransactCardItem
import com.dev.chacha.transaction.presentation.transaction.TransactionHeader
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityDivider
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

    val newTransactUiState by transactViewModel.newTransactUiState.collectAsStateWithLifecycle()
    val isRemittanceCategory = newTransactUiState.selectedCategory == "Remittance"


    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Transact",
                showNotifications = true,
                notificationCount = 100,
                showBackArrow = true
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .padding(paddingValues)
        ) {

            if (newTransactUiState.selectedCategory == "All"){
                AllTransactionScreen(navController = navController)
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    item(span = { GridItemSpan(3) }) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ){
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
                                    modifier = Modifier.tabIndicatorOffset(tabPositions[newTransactUiState
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
                                    modifier = Modifier.padding(horizontal = 8.dp),

                                ) {
                                    OutlinedButton(
                                        onClick = {transactViewModel.selectCategory(category) },
                                        border = BorderStroke(
                                            1.dp, color = if (newTransactUiState.selectedCategory == category) MaterialTheme.colorScheme.primary else Color.Gray
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
                        AnimatedVisibility(visible = newTransactUiState.selectedProducts.isEmpty()) {
                            SchedulePaymentCard()

                        }
                    }
                    item(span = { GridItemSpan(3) }) {
                        if (newTransactUiState.selectedCategory != null) {
                            Text(
                                text = newTransactUiState.selectedCategory!!, // Display the selected category title
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.titleLarge

                            )
                        }

                    }

                    items(newTransactUiState.selectedProducts.size) { product ->
                        AnimatedVisibility(
                            visible = newTransactUiState.selectedProducts.isNotEmpty(),
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            TransactCardItem(
                                text = newTransactUiState.selectedProducts[product].text,
                                icon = newTransactUiState.selectedProducts[product].icon,
                                onClick = { sendMoneyOption->
                                    when (sendMoneyOption) {
                                        R.string.own_equity_account -> { navController.navigate(OWN_EQUITY_ACCOUNT_ROUTE) }
                                        R.string.another_equity_account -> { navController.navigate(ANOTHER_EQUITY_ACCOUNT_ROUTE) }
                                        R.string.pay_top_up -> { navController.navigate(PAY_TO_CARD_ROUTE) }
                                        R.string.mobile_wallet -> { navController.navigate(MOBILE_WALLET_ROUTE) }
                                        R.string.another_bank -> { navController.navigate(ANOTHER_BANK_ROUTE) }
                                        R.string.pay_bill -> { navController.navigate(PAY_BILL_ROUTE) }
                                        R.string.buy_goods -> { navController.navigate(BUY_GOODS_ROUTE) }
                                        R.string.buy_airtime -> { navController.navigate(BUY_AIRTIME_ROUTE) }
                                        R.string.agent -> { navController.navigate(WITHDRAW_CASH_AGENT_ROUTE) }
                                        R.string.paypal_hint -> { navController.navigate(PAYPAL_ROUTE) }
                                        R.string.western_union_hint -> { navController.navigate(WESTERN_UNION_ROUTE) }

                                    }
                                },
                                showDrawableColorTint = isRemittanceCategory
                            )

                        }

                    }

                    item(span = { GridItemSpan(3) }) {
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                }
            }

        }

    }

}


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
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun FilterChip(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
) {
    // Customize the appearance of your filter chip, e.g., use a Chip or Button composable
    Button(
        onClick = { onSelectedChange(!selected) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color.Gray else Color.LightGray,
        ),
        modifier = modifier
    ) {
        Text(text = text)
    }
}



