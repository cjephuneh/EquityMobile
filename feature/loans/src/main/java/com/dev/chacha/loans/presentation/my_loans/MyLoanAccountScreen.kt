package com.dev.chacha.loans.presentation.my_loans

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.components.EquityDivider

@Composable
@Preview
fun MyLoanAccountScreen() {
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
                    EquityLoanAccountCard()
                }

                item {
                    LoanTransactionServices()
                }
                item { 
                    EquityDivider()
                }

                item {
                    LoanTransactionSearch(
                        initialValue = "" ,
                        onSearchParamChange ={}
                    )
                }
                items(10){
                    LoanTransactionHistoryItem()
                }
            }

        }

    }

}