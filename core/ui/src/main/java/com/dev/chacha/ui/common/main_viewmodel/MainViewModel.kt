package com.dev.chacha.ui.common.main_viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    fun onMainEvent(event: MainUiEvent){
        when(event){
            is MainUiEvent.OnAmountChanged -> {
                _uiState.update { it.copy(amount = event.amount) }
            }
            is MainUiEvent.OnPhoneChanged -> {
                _uiState.update { it.copy(phoneNumber = event.phoneNumber) }

            }
            is MainUiEvent.OnTransactionBillerChanged -> {
                _uiState.update { it.copy(transactionBiller = event.transactionBiller) }

            }
        }
    }
}