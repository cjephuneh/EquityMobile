package com.dev.chacha.ui.common.main_viewmodel

data class MainUiState(
    val amount: String = "",
    val currency: String = "",
    val transactionReason: String = "",
    val transactionBiller: String = "",
    val phoneNumber: String = ""
)
