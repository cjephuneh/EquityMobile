package com.dev.chacha.loans.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar


@Composable
fun BorrowScreen(
    onNavigateToPayLoan:()->Unit = {},
    onNavigateToGetLoan: () -> Unit ={}
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Borrow",
                showForwardArrow = true,
            )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "What would you like to do",
                        style = MaterialTheme.typography.titleLarge
                        )
                    Text(
                        text = stringResource(id = R.string.loans),
                        style = MaterialTheme.typography.titleLarge
                    )

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ){
                        item {
                            Box{}
                        }
                        item {
                            LoanItemRow(
                                drawable = R.drawable.real_estate,
                                title = R.string.get_loan,
                                onItemClick = { onNavigateToGetLoan()}
                            )
                        }
                        item {
                             Box(
                                 modifier = Modifier.fillMaxWidth(),
                             ) {
                                 Divider(
                                     thickness = 1.dp,
                                     modifier = Modifier.padding(start = 65.dp, end = 8.dp)
                                 )
                             }
                        }

                        item {
                            LoanItemRow(
                                drawable = R.drawable.pay_loan,
                                title = R.string.pay_loan,
                                onItemClick = {
                                    onNavigateToPayLoan()
                                }
                            )
                        }
                    }

                }
            }

        }

    }


}

@Composable
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        BorrowScreen()
    }

}
