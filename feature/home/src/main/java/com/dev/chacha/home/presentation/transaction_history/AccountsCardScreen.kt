package com.dev.chacha.home.presentation.transaction_history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.components.EquityDivider
import com.dev.chacha.ui.common.pager.BasicIndicator
import com.dev.chacha.ui.common.pager.StackPager
import com.dev.chacha.ui.common.pager.rememberPagerSwipeState

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun AccountCardScreen() {
    val linearPagerSwipeState = rememberPagerSwipeState()
    val stackPagerSwipeState = rememberPagerSwipeState()
    val context = LocalContext.current
    val density = LocalDensity.current


    // Calculate the screen width in pixels
    val screenWidthPx = density.run {
        context.resources.displayMetrics.widthPixels.toFloat()
    }
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Spacer(modifier = Modifier.height(50.dp))
                }
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        StackPager(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.background)
                                .padding(horizontal = 50.dp),
                            data = accounts,
                            pagerSwipeState = stackPagerSwipeState,
                            stackOffsetStep = 10.dp,
                            widthPx = screenWidthPx
                        ) { account, index ->

                            EquityAccountCard(stackData = account)

                        }

                        BasicIndicator(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(20.dp),
                            swipeState = stackPagerSwipeState
                        )
                    }

                }

                item {
                    TransactionServices()
                }
                item {
                    EquityDivider()
                }

                item {
                    TransactionSearch(
                        initialValue = "",
                        onSearchParamChange = {}
                    )
                }
                items(transactionHistoryList.size) { index ->
                    TransactionHistoryItem(
                        transactionData = transactionHistoryList[index],
                        onClickItem = {}
                    )

                    if (index < transactionHistoryList.size - 1) {
                        EquityDivider()
                    }
                }
            }

        }

    }

}