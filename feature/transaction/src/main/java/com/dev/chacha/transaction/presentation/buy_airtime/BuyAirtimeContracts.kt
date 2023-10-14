package com.dev.chacha.transaction.presentation.buy_airtime

import com.dev.chacha.ui.common.country_search.Country

data class BuyAirtimeUiState(
    val mobileNumber: String = "",
    val amount: String = "",
    val currency: String = "",
    val paymentReason: String = "",
    val countryName: String = "",
    val countryCode: String = "",
    val countryFullName: String = "",
    val country: Country? = null,
    val simOperator: String = ""
    )

sealed interface BuyAirtimeUiEvent{
    data class OnMobileNumberChanged(val mobileNumber: String): BuyAirtimeUiEvent
    data class OnAmountChanged(val amount: String): BuyAirtimeUiEvent
    data class OnCurrencyChanged(val currency: String): BuyAirtimeUiEvent
    data class OnCountryNameSelected(val countryName: String): BuyAirtimeUiEvent
    data class OnCountryCodeSelected(val countryCode: String): BuyAirtimeUiEvent
    data class OnCountryFullNameSelected(val countryFullName: String): BuyAirtimeUiEvent
    data class OnSelectSimOperator(val simOperator: String): BuyAirtimeUiEvent
}