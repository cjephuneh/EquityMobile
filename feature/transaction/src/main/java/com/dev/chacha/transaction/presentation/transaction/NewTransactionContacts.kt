package com.dev.chacha.transaction.presentation.transaction

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dev.chacha.ui.R

data class Transact(
    val sendMoneyItem: List<SendMoneyItem>

)

data class NewTransactUiState(
    val transactProducts: List<SendMoneyItem> = emptyList(),
    val selectedCategory: String? = null,
    val transactProductCategories: Set<String> = emptySet(),
    val selectedProduct: SendMoneyItem? = null,
    val selectedProductss: List<SendMoneyItem> = emptyList(),
    val isRemittanceCategorySelected: Boolean = false, // Define this property
    val selectAllCategories: Boolean = false, // Flag to select all categories



){
    val categories = transactProducts.map { it.category }.toSet()
    val selectedProducts = transactProducts.filter { it.category == selectedCategory }

    // Function to get products for all categories
    fun selectedProductsForAllCategories(): List<SendMoneyItem> {
        return if (selectAllCategories) {
            transactProducts
        } else {
            selectedProducts
        }
    }


}

sealed interface TransactionListEvent {
    data class ProductLoaded(val products: List<SendMoneyItem>) : TransactionListEvent
    data class OnSelectedProduct(val product: SendMoneyItem): TransactionListEvent
    object OnLoadCategories : TransactionListEvent
    object OnLoadProducts : TransactionListEvent

}


data class SendMoneyItem(
    @StringRes val text: Int,
    @DrawableRes val icon: Int,
    val category: String
)

val sendMoneyList = listOf(
    SendMoneyItem(
        text = R.string.own_equity_account,
        icon = R.drawable.sync_alt,
        category = "Send Money"
    ),
    SendMoneyItem(
        text = R.string.another_equity_account,
        icon = R.drawable.ic_input_24,
        category = "Send Money"

    ),
    SendMoneyItem(
        text = R.string.pay_top_up,
        icon = R.drawable.account_balance,
        category = "Send Money"

    ),
    SendMoneyItem(
        text = R.string.mobile_wallet,
        icon = R.drawable.outline_send_to_mobile_24,
        category = "Send Money"

    ),
    SendMoneyItem(
        text = R.string.another_bank,
        icon = R.drawable.account_balance,
        category = "Send Money"

    )

)

val remittanceItemList = listOf(
    SendMoneyItem(
        text = R.string.paypal_hint,
        icon = R.drawable.paypal_icons,
        category = "Remittance"

    ),
    SendMoneyItem(
        text = R.string.western_union_hint,
        icon = R.drawable.western_union_icon,
        category = "Remittance"

    )

)

val withdrawCashList = listOf(
    SendMoneyItem(
        text = R.string.agent,
        icon = R.drawable.leaderboard,
        category = "Withdraw Cash"

    ),
)

val payWithEquityList = listOf(
    SendMoneyItem(
        text = R.string.pay_bill,
        icon = R.drawable.receipt,
        category = "Pay With Equity"

    ),
    SendMoneyItem(
        text = R.string.buy_goods,
        icon = R.drawable.trolley,
        category = "Pay With Equity"

    )
)

val buyAirtime = listOf(
    SendMoneyItem(
        text = R.string.buy_airtime,
        icon = R.drawable.outline_phone_android,
        category = "Buy airtime"

    )
)

val all = listOf(
    SendMoneyItem(
        text = R.string.buy_airtime,
        icon = R.drawable.outline_phone_android,
        category = "All"

    )
)

val allList = listOf(
    sendMoneyList,
    payWithEquityList,
    withdrawCashList,
    buyAirtime,
    remittanceItemList
)
