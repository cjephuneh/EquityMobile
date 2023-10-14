package com.dev.chacha.transaction.presentation.send_money.mobile_money

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MobileMoneyViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MobileMoneyUiState())
    val uiState  = _uiState.asStateFlow()

    fun onMobileMoneyEvent(event: MobileMoneyUiEvent){
        when(event){
            is MobileMoneyUiEvent.OnAmountChanged -> {
                _uiState.update { it.copy(amount = event.amount) }
            }
            is MobileMoneyUiEvent.OnCurrencyChanged -> {
                _uiState.update { it.copy(currency = event.currency) }

            }
            is MobileMoneyUiEvent.OnMobileNumberChanged -> {
                _uiState.update { it.copy(mobileNumber = event.mobileNumber) }

            }
        }
    }
}