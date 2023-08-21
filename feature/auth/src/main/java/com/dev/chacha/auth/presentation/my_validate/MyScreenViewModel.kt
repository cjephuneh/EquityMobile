@file:OptIn(ExperimentalCoroutinesApi::class)

package com.dev.chacha.auth.presentation.my_validate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn

class MyScreenViewModel(
    private val validatePassword: ValidatePassword = ValidatePassword()
) : ViewModel() {
    var password by mutableStateOf("")
        private set

    var confirmPassword by mutableStateOf("") // New confirmation password state
        private set

    @OptIn(ExperimentalCoroutinesApi::class)
    val passwordError =
        snapshotFlow { password }
            .combine(snapshotFlow { confirmPassword }) { pass, confirmPass ->
                validatePassword.execute(pass, confirmPass)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = PasswordValidationState()
            )

    fun changePassword(value: String) {
        password = value
    }

    fun changeConfirmPassword(value: String) {
        confirmPassword = value
    }

}