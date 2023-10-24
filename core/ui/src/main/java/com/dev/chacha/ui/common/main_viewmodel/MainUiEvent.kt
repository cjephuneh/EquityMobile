package com.dev.chacha.ui.common.main_viewmodel

sealed interface MainUiEvent{
    data class OnAmountChanged(val amount: String): MainUiEvent
    data class OnPhoneChanged(val phoneNumber: String): MainUiEvent

    data class OnTransactionBillerChanged(val transactionBiller: String): MainUiEvent
}