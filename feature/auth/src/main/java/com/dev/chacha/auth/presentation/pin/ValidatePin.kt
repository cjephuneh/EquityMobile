package com.dev.chacha.auth.presentation.pin

class ValidatePin {
    fun execute(pin: String, confirmPIN: String): PinValidationState {
        val validateMinimum = validateMinimum(pin)
        val validatePIN = validatePIN(pin)
        val validateConfirmPIN = pin == confirmPIN // Check confirm PIN match
        val validateNoSequences = !hasNumberSequences(pin)
        val validateNoRepetitiveDigits = !hasRepetitiveDigits(pin)

        val hasError = listOf(
            validateMinimum,
            validatePIN,
            validateConfirmPIN,
            validateNoSequences,
            validateNoRepetitiveDigits
        ).all { it }

        return PinValidationState(
            hasMinimum = validateMinimum,
            hasValidPIN = validatePIN,
            hasValidConfirmPIN = validateConfirmPIN,
            hasNoSequences = validateNoSequences,
            hasNoRepetitiveDigits = validateNoRepetitiveDigits,
            successful = hasError
        )
    }

    private fun validatePIN(pin: String): Boolean =
        pin.matches(Regex("\\d{4}"))

    private fun validateMinimum(pin: String): Boolean =
        pin.matches(Regex("\\d{4}"))

    private fun hasNumberSequences(pin: String): Boolean =
        pin.contains(Regex("1234|2345|3456|4567|5678|6789"))

    private fun hasRepetitiveDigits(pin: String): Boolean =
        pin.matches(Regex("(\\d)\\1{3,}"))


}