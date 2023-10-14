package com.dev.chacha.validation

data class PasswordValidationState(
    val hasMinimum: Boolean = false,
    val hasCapitalizedLetter: Boolean = false,
    val hasSpecialCharacter: Boolean = false,
    val hasPasswordMatch: Boolean = false, // New flag for password confirmation match
    val successful: Boolean = false
)
