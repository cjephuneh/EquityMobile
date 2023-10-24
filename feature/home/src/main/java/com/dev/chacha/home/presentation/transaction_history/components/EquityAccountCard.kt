package com.dev.chacha.home.presentation.transaction_history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EquityAccountCard(
    stackData: StackData,
    ) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, RoundedCornerShape(10.dp))
                .height(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Text(
                    text = stackData.accountName,
                    fontSize = 12.sp

                )
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Savings Account",
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 12.sp

                    )
                    Text(
                        text = stackData.accountNumber,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 12.sp

                    )
                }
            }
        }

    }

}

@Composable
fun Balance() {
    Column {
        Text(
            text = "Savings Account",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "50.56 KES",
            style = MaterialTheme.typography.titleLarge
        )
    }

}

data class StackData(
    val accountName: String,
    val amount: String,
    val accountNumber: String
)

val accounts = listOf(
    StackData(
        "Stephen Chacha",
        "200",
        "01234567890"
    ),
    StackData(
        "Stephen Chacha Marwa",
        "2000",
        "01234067890"
    )
)