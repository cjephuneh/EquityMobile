package com.dev.chacha.auth.presentation.register

import com.dev.chacha.ui.common.country_search.Country

data class RegisterUiState(
    val mobileNumber: String = "",
    val amount: String = "",
    val currency: String = "",
    val paymentReason: String = "",
    val countryName: String = "",
    val countryCode: String = "",
    val countryFullName: String = "",
    val country: Country? = null
    )

sealed interface RegisterUiEvent{
    data class OnMobileNumberChanged(val mobileNumber: String): RegisterUiEvent
    data class OnAmountChanged(val amount: String): RegisterUiEvent
    data class OnCurrencyChanged(val currency: String): RegisterUiEvent
    data class OnCountryNameSelected(val countryName: String): RegisterUiEvent
    data class OnCountryCodeSelected(val countryCode: String): RegisterUiEvent
    data class OnCountryFullNameSelected(val countryFullName: String): RegisterUiEvent
}