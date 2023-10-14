package com.dev.chacha.auth.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    var mobileNumber by mutableStateOf("")
    var mobileCountryCode by mutableStateOf("")

    val countriesList = getCountriesList()
    var mobileCountry by mutableStateOf<Country?>(null)

    private val _accountNumberText = mutableStateOf("")
    val accountNumber: State<String> = _accountNumberText

    private val _idNumberError = mutableStateOf("")
    val idNumberError: State<String> = _idNumberError

    private val _idNumberText = mutableStateOf("")
    val idNumberText: State<String> = _idNumberText


    private val _accountNumberError = mutableStateOf("")
    val accountNumberError: State<String> = _accountNumberError


    private val _rememberMeState = mutableStateOf(false)
    val rememberMeState: State<Boolean> = _rememberMeState
    fun setRememberMe(value: Boolean) {
        _rememberMeState.value = value
    }

    fun setAccountNumber(accountNumber: String) {
        _accountNumberText.value = accountNumber
    }

    fun setIdNumberText(idNumber: String) {
        _idNumberText.value = idNumber
    }

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState = _uiState.asStateFlow()

    fun onRegisterEvent(event: RegisterUiEvent) {
        when (event) {
            is RegisterUiEvent.OnAmountChanged -> {
                _uiState.update { it.copy(amount = event.amount) }
            }

            is RegisterUiEvent.OnCurrencyChanged -> {
                _uiState.update { it.copy(currency = event.currency) }

            }

            is RegisterUiEvent.OnMobileNumberChanged -> {
                _uiState.update { it.copy(mobileNumber = event.mobileNumber) }

            }

            is RegisterUiEvent.OnCountryCodeSelected -> {
                _uiState.update { it.copy(countryCode = event.countryCode) }
            }
            is RegisterUiEvent.OnCountryFullNameSelected -> {
                _uiState.update { it.copy(countryFullName = event.countryFullName) }

            }
            is RegisterUiEvent.OnCountryNameSelected -> {
                _uiState.update { it.copy(countryName = event.countryName) }

            }
        }
    }

}