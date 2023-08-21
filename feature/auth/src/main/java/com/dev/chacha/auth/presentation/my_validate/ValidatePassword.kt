package com.dev.chacha.auth.presentation.my_validate

class ValidatePassword {
    fun execute(password: String, confirmPassword: String): PasswordValidationState {
        val validateSpecialCharacter = validateSpecialCharacter(password)
        val validateCapitalizedLetter = validateCapitalizedLetter(password)
        val validateMinimum = validateMinimum(password)
        val validatePasswordMatch = password == confirmPassword // Check password confirmation match

        val hasError = listOf(
            validateMinimum,
            validateCapitalizedLetter,
            validateSpecialCharacter,
            validatePasswordMatch
        ).all { it }

        return PasswordValidationState(
            hasMinimum = validateMinimum,
            hasSpecialCharacter = validateSpecialCharacter,
            hasCapitalizedLetter = validateCapitalizedLetter,
            hasPasswordMatch = validatePasswordMatch, // Set the password confirmation match flag
            successful = hasError
        )
    }


    private fun validateSpecialCharacter(password: String): Boolean =
        password.matches(Regex("[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]"))

    private fun validateCapitalizedLetter(password: String): Boolean =
        password.matches(Regex(".*[A-Z].*"))

    private fun validateMinimum(password: String): Boolean =
        password.matches(Regex(".{8,}"))
}