package com.dev.chacha.transaction.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SendToBankItem(
    bank: Bank,
    selected: Boolean = false,
    selectedBank:(Bank)->Unit ={}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f).padding(end = 16.dp)
        ) {
            Text(text = bank.bankName)
            Text(text = "${bank.bankNo}.${bank.bankUserName}")
        }
        RadioButton(
            selected = selected,
            onClick = { selectedBank(bank) }
        )
    }

}

data class Bank(
    val bankCountry: String,
    val bankName: String,
    val bankNo: String,
    val bankUserName: String
)

val bankList = listOf(
    Bank("Kenya", "Absa", "03", "ABSA BANK KENYA"),
    Bank("Kenya", "Absa", "03", "ABSA BANK KENYA"),
    Bank("Kenya", "Absa", "03", "ABSA BANK KENYA"),

)