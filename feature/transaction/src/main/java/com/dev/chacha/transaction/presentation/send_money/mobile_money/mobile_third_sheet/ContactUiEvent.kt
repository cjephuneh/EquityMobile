package com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_third_sheet

sealed interface ContactUiEvent{
    object GetContacts: ContactUiEvent
    data class SearchContact(val searchParams: String): ContactUiEvent

}