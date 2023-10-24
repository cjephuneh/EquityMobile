package com.dev.chacha.data

sealed interface BiometricUiEvent{
    data class EnableBiometricToggled(val isBiometricEnabled: Boolean): BiometricUiEvent
}