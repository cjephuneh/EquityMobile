package com.dev.chacha.more.presentation

sealed interface MoreUiEvent{
    data class EnableBiometricToggled(val isBiometricEnabled: Boolean): MoreUiEvent
    data class EnableEventToggled(val isEventEnabled: Boolean): MoreUiEvent
    data class EnableMarketContentToggled(val isMarketContentEnabledEnabled: Boolean): MoreUiEvent
    data class EnableServiceUpdateToggled(val isServiceUpdateEnabled: Boolean): MoreUiEvent
    data class EnableBankAlertToggled(val isBankAlertEnabled: Boolean): MoreUiEvent

}