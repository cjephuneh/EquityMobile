package com.dev.chacha.transaction.presentation.send_money.another_equity_account

import com.dev.chacha.ui.common.country_search.Country

data class EquityAccountUiState(
    val mobileNumber: String = "",
    val amount: String = "",
    val currency: String = "",
    val paymentReason: String = "",
    val countryName: String = "",
    val countryCode: String = "",
    val countryFullName: String = "",
    val country: Country? = null
    )

sealed interface EquityAccountUiEvent{
    data class OnMobileNumberChanged(val mobileNumber: String): EquityAccountUiEvent
    data class OnAmountChanged(val amount: String): EquityAccountUiEvent
    data class OnCurrencyChanged(val currency: String): EquityAccountUiEvent
    data class OnCountryNameSelected(val countryName: String): EquityAccountUiEvent
    data class OnCountryCodeSelected(val countryCode: String): EquityAccountUiEvent
    data class OnCountryFullNameSelected(val countryFullName: String): EquityAccountUiEvent
    data class OnCountrySelected(val country: Country?): EquityAccountUiEvent
}