package com.dev.chacha.loans.presentation.my_loans

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LoanTransactionHistoryItem() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier= Modifier
                .weight(1f)
                .padding(end = 12.dp)
        ) {
            Text(
                text = "Transaction Description",
                style = MaterialTheme.typography.labelSmall

            )
            Text(
                text = "Transaction Number",
                style = MaterialTheme.typography.labelSmall

            )
            Text(
                text = "Transaction Date",
                style = MaterialTheme.typography.labelSmall

            )
        }

        Text(
            text = "Amount",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelSmall
        )

    }

}