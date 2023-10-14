package com.dev.chacha.transaction.presentation.send_money.mobile_money

sealed interface MobileMoneyUiEvent{
    data class OnMobileNumberChanged(val mobileNumber: String): MobileMoneyUiEvent
    data class OnAmountChanged(val amount: String): MobileMoneyUiEvent
    data class OnCurrencyChanged(val currency: String): MobileMoneyUiEvent
}