package com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_third_sheet

data class ContactState(
    val isLoading: Boolean = false,
    val contact: List<Contact> = emptyList(),
    val error: String = "",
    val searchQuery: String = "",
    var searchParams: String = ""

)
