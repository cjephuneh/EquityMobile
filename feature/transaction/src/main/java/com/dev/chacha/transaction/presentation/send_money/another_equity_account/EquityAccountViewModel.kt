package com.dev.chacha.transaction.presentation.send_money.another_equity_account

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dev.chacha.transaction.presentation.buy_airtime.BuyAirtimeUiEvent
import com.dev.chacha.transaction.presentation.buy_airtime.BuyAirtimeUiState
import com.dev.chacha.ui.common.country_search.Country
import com.dev.chacha.ui.common.country_search.getCountriesList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EquityAccountViewModel : ViewModel() {


    var mobileCountryCode by mutableStateOf("")

    val countriesList = getCountriesList()
    var mobileCountry by mutableStateOf<Country?>(null)

    private val _uiState = MutableStateFlow(EquityAccountUiState())
    val uiState = _uiState.asStateFlow()

    fun onEquityAccountEvent(event: EquityAccountUiEvent) {
        when (event) {
            is EquityAccountUiEvent.OnAmountChanged -> {
                _uiState.update { it.copy(amount = event.amount) }
            }

            is EquityAccountUiEvent.OnCurrencyChanged -> {
                _uiState.update { it.copy(currency = event.currency) }

            }

            is EquityAccountUiEvent.OnMobileNumberChanged -> {
                _uiState.update { it.copy(mobileNumber = event.mobileNumber) }

            }

            is EquityAccountUiEvent.OnCountryCodeSelected -> {
                _uiState.update { it.copy(countryCode = event.countryCode) }
            }
            is EquityAccountUiEvent.OnCountryFullNameSelected -> {
                _uiState.update { it.copy(countryFullName = event.countryFullName) }

            }
            is EquityAccountUiEvent.OnCountryNameSelected -> {
                _uiState.update { it.copy(countryName = event.countryName) }

            }

            is EquityAccountUiEvent.OnCountrySelected -> {
                _uiState.update { it.copy(country = event.country) }
            }

        }
    }

}