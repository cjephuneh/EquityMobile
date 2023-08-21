package com.dev.chacha.transaction.presentation.transaction

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TransactViewModel : ViewModel(){
    private val _shouldShowDialog = mutableStateOf(true)
    val shouldShowDialog: State<Boolean> = _shouldShowDialog

    fun setShowDialogState(value: Boolean) {
        _shouldShowDialog.value = value
    }
}