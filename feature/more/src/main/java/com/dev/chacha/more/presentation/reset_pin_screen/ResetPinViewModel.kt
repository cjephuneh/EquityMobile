package com.dev.chacha.more.presentation.reset_pin_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.chacha.validate_pin.PinValidationState
import com.dev.chacha.validate_pin.ValidatePin
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class ResetPinViewModel (
    private val validatePassword: ValidatePin = ValidatePin()
): ViewModel() {

    var currentPIN by mutableStateOf("")
        private set

    var newPIN by mutableStateOf("") // New confirm PIN state
        private set

    var confirmNewPIN by mutableStateOf("") // New confirm PIN state
        private set

    @OptIn(ExperimentalCoroutinesApi::class)
    val pinError =
        snapshotFlow { newPIN }
            .combine(snapshotFlow { confirmNewPIN }) { pin, confirmPin ->
                validatePassword.execute(pin, confirmPin)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = PinValidationState()
            )

    fun changeCurrentPIN(value: String) {
        currentPIN = value
    }

    fun changeNewPIN(value: String) {
        newPIN = value
    }

    fun changeConfirmPIN(value: String) {
        confirmNewPIN = value
    }

    private val _currentPINText = mutableStateOf("")
    val currentPINText: State<String> = _currentPINText

    private val _currentPINError = mutableStateOf("")
    val currentPINError: State<String> = _currentPINError

    fun setCurrentPINText(password: String) {
        _currentPINText.value = password
    }

    fun setIsCurrentPinError(error: String) {
        _currentPINError.value = error
    }


    private val _newPINText = mutableStateOf("")
    val newPINText: State<String> = _newPINText

    private val _newPINError = mutableStateOf("")
    val newPINError: State<String> = _newPINError

    fun setNewPinText(username: String) {
        _newPINText.value = username
    }


    fun setIsNewPinError(error: String) {
        _newPINError.value = error
    }

    private val _confirmPINText = mutableStateOf("")
    val confirmPINText: State<String> = _confirmPINText

    private val _confirmPINError = mutableStateOf("")
    val confirmPINError: State<String> = _confirmPINError

    fun setConfirmPinText(username: String) {
        _confirmPINText.value = username
    }


    fun setIsConfirmPinError(error: String) {
        _confirmPINError.value = error
    }


    private val _showPIN = mutableStateOf(false)
    val showPIN: State<Boolean> = _showPIN

    fun setShowPIN(showPassword: Boolean) {
        _showPIN.value = showPassword
    }
}