package com.dev.chacha.transaction.presentation.create_pin

data class PinValidationState(
    val hasMinimum: Boolean = false,
    val hasValidPIN: Boolean = false,
    val hasValidConfirmPIN: Boolean = false, // New flag for valid confirm PIN
    val successful: Boolean = false,
    val hasNoSequences:Boolean = false,
    val hasNoRepetitiveDigits: Boolean = false
)
