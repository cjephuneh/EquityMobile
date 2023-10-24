package com.dev.chacha.more.presentation.reset_password_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.chacha.validation.PasswordValidationState
import com.dev.chacha.validation.ValidatePassword
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class ResetPasswordViewModel(
    private val validatePassword: ValidatePassword = ValidatePassword()

) : ViewModel() {

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    var currentPassword by mutableStateOf("")
        private set
    var newPassword by mutableStateOf("")
        private set

    var confirmNewPassword by mutableStateOf("") // New confirmation password state
        private set

    @OptIn(ExperimentalCoroutinesApi::class)
    val passwordError =
        snapshotFlow { newPassword }
            .combine(snapshotFlow { confirmNewPassword }) { pass, confirmPass ->
                validatePassword.execute(pass, confirmPass)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = PasswordValidationState()
            )


    fun changeCurrentPassword(value: String) {
        currentPassword = value
    }

    fun changePassword(value: String) {
        newPassword = value
    }



    fun changeConfirmNewPassword(value: String) {
        confirmNewPassword = value
    }





    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText



    fun setPasswordText(password: String) {
        _passwordText.value = password
    }


    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }
}