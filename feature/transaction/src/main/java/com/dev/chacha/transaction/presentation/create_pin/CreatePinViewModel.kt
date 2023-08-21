package com.dev.chacha.transaction.presentation.create_pin

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class CreatePinViewModel(
    private val validatePassword: ValidatePin = ValidatePin()
) : ViewModel() {

    var pin by mutableStateOf("")
        private set

    var confirmPIN by mutableStateOf("") // New confirm PIN state
        private set

    @OptIn(ExperimentalCoroutinesApi::class)
    val pinError =
        snapshotFlow { pin }
            .combine(snapshotFlow { confirmPIN }) { pin, confirmPin ->
                validatePassword.execute(pin, confirmPin)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = PinValidationState()
            )

    fun changePin(value: String) {
        pin = value
    }

    fun changeConfirmPIN(value: String) {
        confirmPIN = value
    }



    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword


    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError


    fun setPasswordText(password: String) {
        _passwordText.value = password
    }



    fun setIsPasswordError(error: String) {
        _passwordError.value = error
    }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

}