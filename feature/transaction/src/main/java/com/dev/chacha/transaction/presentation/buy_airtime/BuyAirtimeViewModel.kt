package com.dev.chacha.transaction.presentation.buy_airtime

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dev.chacha.ui.common.country_search.Country
import com.dev.chacha.ui.common.country_search.getCountriesList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BuyAirtimeViewModel : ViewModel() {
    var mobileCountryCode by mutableStateOf("")

    val countriesList = getCountriesList()
    var mobileCountry by mutableStateOf<Country?>(null)

    private val _uiState = MutableStateFlow(BuyAirtimeUiState())
    val uiState = _uiState.asStateFlow()

    fun onBuyAirtimeEvent(event: BuyAirtimeUiEvent) {
        when (event) {
            is BuyAirtimeUiEvent.OnAmountChanged -> {
                _uiState.update { it.copy(amount = event.amount) }
            }

            is BuyAirtimeUiEvent.OnCurrencyChanged -> {
                _uiState.update { it.copy(currency = event.currency) }
            }

            is BuyAirtimeUiEvent.OnMobileNumberChanged -> {
                _uiState.update { it.copy(mobileNumber = event.mobileNumber) }
            }

            is BuyAirtimeUiEvent.OnCountryCodeSelected -> {
                _uiState.update { it.copy(countryCode = event.countryCode) }
            }
            is BuyAirtimeUiEvent.OnCountryFullNameSelected -> {
                _uiState.update { it.copy(countryFullName = event.countryFullName) }

            }
            is BuyAirtimeUiEvent.OnCountryNameSelected -> {
                _uiState.update { it.copy(countryName = event.countryName) }

            }

            is BuyAirtimeUiEvent.OnSelectSimOperator -> {
                _uiState.update { it.copy(simOperator = event.simOperator) }

            }
        }
    }
}