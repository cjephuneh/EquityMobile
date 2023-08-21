package com.dev.chacha.auth.presentation.pin

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


class PinScreenViewModel(
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

    fun changePassword(value: String) {
        pin = value
    }

    fun changeConfirmPIN(value: String) {
        confirmPIN = value
    }
}
