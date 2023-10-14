package com.dev.chacha.transaction.presentation.send_money.mobile_money

data class MobileMoneyUiState(
    val mobileNumber: String = "",
    val amount: String = "",
    val currency: String = "",
    val paymentReason: String = "",

)
