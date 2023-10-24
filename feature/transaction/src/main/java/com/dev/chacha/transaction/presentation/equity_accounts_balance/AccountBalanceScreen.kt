package com.dev.chacha.transaction.presentation.equity_accounts_balance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun AccountBalanceScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Pay from",
                showBackArrow = true,
                onNavigateBack = {}
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Please Select an account",
                style = MaterialTheme.typography.titleLarge
            )

            Box{
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(bankAccountTypeList){
                        AccountBottomSheetItem(
                            onSelectedAccount = {},
                            bankAccountType = it
                        )
                    }
                }
            }

        }
    }

}

@Composable
fun AccountBottomSheetItem(
    selectedAccount: Boolean = false,
    onSelectedAccount:(BankAccountType)->Unit,
    bankAccountType: BankAccountType
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        ) {
            RadioButton(
                selected = selectedAccount ,
                onClick = { onSelectedAccount(bankAccountType) }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = bankAccountType.accountUserName,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Available balance ${bankAccountType.accountType.availableBalance}",
                    style = MaterialTheme.typography.bodySmall

                )
                Text(
                    text =  "${bankAccountType.accountNumber} ${bankAccountType.accountType.accountType}",
                    style = MaterialTheme.typography.bodySmall

                )

            }
        }


    }
}

val bankAccountTypeList = listOf(
    BankAccountType(
        accountUserName = "Stephen Chacha",
        accountNumber = "1234567890",
        accountType = EquityAccountType("1000", EquityBankAccounts.Savings)
    )
)

data class BankAccountType(
    val accountUserName: String,
    val accountNumber: String,
    val accountType: EquityAccountType
)


data class EquityAccountType(
    val availableBalance: String,
    val accountType: EquityBankAccounts = EquityBankAccounts.Savings
)

enum class EquityBankAccounts {
        Savings,
        Business

}

