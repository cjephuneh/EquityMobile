package com.dev.chacha.home.presentation.transaction_history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.home.presentation.home_screen.HomeViewModel
import com.dev.chacha.ui.common.components.EquityDivider
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.loading_indicator.LoadingIndicator
import com.dev.chacha.ui.common.pager.BasicIndicator
import com.dev.chacha.ui.common.pager.StackPager
import com.dev.chacha.ui.common.pager.rememberPagerSwipeState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun AccountCardScreen() {
    val linearPagerSwipeState = rememberPagerSwipeState()
    val stackPagerSwipeState = rememberPagerSwipeState()
    val context = LocalContext.current
    val density = LocalDensity.current

    val homeViewModel: HomeViewModel = viewModel()
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()




    // Calculate the screen width in pixels
    val screenWidthPx = density.run {
        context.resources.displayMetrics.widthPixels.toFloat()
    }
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Accounts"
            )
        }
    ) { paddingValues ->
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

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Savings",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "56.67 KES",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )

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