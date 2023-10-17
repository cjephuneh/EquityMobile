package com.dev.chacha.home.presentation.transaction_history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TransactionHistoryItem(
    transactionData: TransactionHistoryItemData,
    onClickItem:(TransactionHistoryItemData)->Unit
) {
    val transactionType = transactionData.transactionType
    val amount = transactionData.amount

    // Determine the currency symbol based on the transaction type
    val currencySymbol = when (transactionType) {
        TransactionType.DEPOSIT -> " " // Customize the symbol as needed
        TransactionType.WITHDRAWAL -> "-" // Customize the symbol as needed
        TransactionType.FEE -> "-" // Customize the symbol as needed
        TransactionType.TRANSFER -> "-" // Customize the symbol as needed
        TransactionType.PURCHASE -> "-" // Customize the symbol as needed
        TransactionType.INTEREST -> "-" // Customize the symbol as needed
        TransactionType.PAYMENT -> "-" // Customize the symbol as needed
        TransactionType.BUY_AIRTIME -> "-" // Customize the symbol as needed
        TransactionType.BUY_GOODS -> "-" // Customize the symbol as needed
        TransactionType.ADJUSTMENT -> "-" // Customize the symbol as needed
        TransactionType.PAY_BILL -> "-" // Customize the symbol as needed
        else -> "" // Default symbol for other transaction types
    }

    // Format the amount with the currency symbol
    val formattedAmount = String.format("%s%.2f KES", currencySymbol, amount)

    // Determine the text color based on the transaction type
    val textColor = when (transactionType) {
        TransactionType.DEPOSIT -> Color.Green // Customize the color as needed
        TransactionType.WITHDRAWAL -> Color.Red // Customize the color as needed
        TransactionType.FEE -> Color.Red // Customize the color as needed
        TransactionType.TRANSFER -> Color.Red // Customize the color as needed
        TransactionType.PURCHASE -> Color.Red // Customize the color as needed
        TransactionType.PAYMENT -> Color.Red // Customize the color as needed
        TransactionType.INTEREST -> Color.Red // Customize the color as needed
        TransactionType.PAY_BILL -> Color.Red // Customize the color as needed
        TransactionType.BUY_GOODS -> Color.Red // Customize the color as needed
        TransactionType.BUY_AIRTIME -> Color.Red // Customize the color as needed
        TransactionType.ADJUSTMENT -> Color.Red // Customize the color as needed
        else -> Color.Green // Default color for other transaction types
    }



    Row(
        modifier = Modifier.fillMaxWidth()
            .clickable(MutableInteractionSource(),null){
                onClickItem(transactionData)
            }
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier= Modifier
                .weight(1f)
                .padding(end = 12.dp)
        ) {
            Text(
                text = transactionData.transactionDescription,
                style = MaterialTheme.typography.labelSmall

            )
            Text(
                text = transactionData.transactionNumber,
                style = MaterialTheme.typography.labelSmall

            )
            Text(
                text = transactionData.transactionDate,
                style = MaterialTheme.typography.labelSmall

            )
        }

        Text(
            text = formattedAmount,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelSmall,
            color = textColor,
            fontWeight = FontWeight.SemiBold

        )

    }

}


data class TransactionHistoryItemData(
    val transactionDescription: String,
    val transactionNumber: String,
    val transactionDate: String,
    val transactionType: TransactionType, // Use an enum for transaction type,
    val amount: Double // Add the amount property

)

val transactionHistoryList = listOf(
    TransactionHistoryItemData(
        transactionDescription = "Deposit",
        transactionNumber = "123456",
        transactionDate = "2023-10-15",
        transactionType = TransactionType.DEPOSIT,
        amount = 150.00
    ),
    TransactionHistoryItemData(
        transactionDescription = "Withdrawal",
        transactionNumber = "789012",
        transactionDate = "2023-10-16",
        transactionType = TransactionType.WITHDRAWAL,
        amount = 500.00

    ),
    TransactionHistoryItemData(
        transactionDescription = "Transfer to Savings",
        transactionNumber = "567890",
        transactionDate = "2023-10-17",
        transactionType = TransactionType.TRANSFER,
        amount = 700.00

    ),
    TransactionHistoryItemData(
        transactionDescription = "Purchase - Electronics",
        transactionNumber = "234567",
        transactionDate = "2023-10-18",
        transactionType = TransactionType.PURCHASE,
        amount = 1870.00

    ),
    TransactionHistoryItemData(
        transactionDescription = "Monthly Payment - Rent",
        transactionNumber = "456789",
        transactionDate = "2023-10-19",
        transactionType = TransactionType.PAYMENT,
        amount = 1089.00

    ),
    TransactionHistoryItemData(
        transactionDescription = "Interest Earned",
        transactionNumber = "345678",
        transactionDate = "2023-10-20",
        transactionType = TransactionType.INTEREST,
        amount = 6800.00

    ),
    TransactionHistoryItemData(
        transactionDescription = "Account Maintenance Fee",
        transactionNumber = "987654",
        transactionDate = "2023-10-21",
        transactionType = TransactionType.FEE,
        amount = 108.00

    ),
    TransactionHistoryItemData(
        transactionDescription = "Adjustment",
        transactionNumber = "876543",
        transactionDate = "2023-10-22",
        transactionType = TransactionType.ADJUSTMENT,
        amount = 52100.00

    ),
    TransactionHistoryItemData(
        transactionDescription = "Unknown Transaction",
        transactionNumber = "654321",
        transactionDate = "2023-10-23",
        transactionType = TransactionType.OTHER,
        amount = 650.00

    )
)



enum class TransactionType {
    DEPOSIT,
    WITHDRAWAL,
    TRANSFER,      // For transferring funds to another account
    PURCHASE,      // For making a purchase using the account
    PAYMENT,       // For making a payment from the account
    INTEREST,      // For receiving interest on the account balance
    FEE,           // For deducting fees from the account
    ADJUSTMENT,    // For any other adjustments or special transactions
    OTHER,
    PAY_BILL,
    BUY_GOODS,
    BUY_AIRTIME
}
