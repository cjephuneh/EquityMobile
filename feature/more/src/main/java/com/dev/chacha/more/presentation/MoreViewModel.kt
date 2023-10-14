package com.dev.chacha.more.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.chacha.data.use_case.BiometricUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreViewModel  @Inject constructor(
    private val biometricUseCase: BiometricUseCase
): ViewModel() {
    private val _moreUiState = MutableStateFlow(MoreUiState())
    val moreUiState: StateFlow<MoreUiState> = _moreUiState

    private val _shouldShowDialog = mutableStateOf(true)
    val shouldShowDialog: State<Boolean> = _shouldShowDialog

    fun setShowDialogState(value: Boolean) {
        _shouldShowDialog.value = value
    }

    init {
        getDarkTheme()
    }


    fun onEvent(event: MoreUiEvent){
        when(event){
            is MoreUiEvent.EnableBiometricToggled -> {
                saveBiometric(isBiometricEnabled  = event.isBiometricEnabled)
                getDarkTheme()
            }

            is MoreUiEvent.EnableBankAlertToggled -> {
                saveBankAlert(isMarketContentEnabled   = event.isBankAlertEnabled)
                getDarkTheme()

            }
            is MoreUiEvent.EnableEventToggled -> {
                saveBankEvent(isMarketContentEnabled   = event.isEventEnabled)
                getDarkTheme()

            }
            is MoreUiEvent.EnableMarketContentToggled -> {
                saveMarketContent(isMarketContentEnabled   = event.isMarketContentEnabledEnabled)
                getDarkTheme()

            }
            is MoreUiEvent.EnableServiceUpdateToggled -> {
                saveServiceUpdate(isMarketContentEnabled   = event.isServiceUpdateEnabled)
                getDarkTheme()
            }
        }
    }

    private fun getDarkTheme() {
        viewModelScope.launch {
            biometricUseCase.execute().collect { enabled ->
                if (enabled != null) {
                    _moreUiState.update { it.copy(isBiometricEnabled  = enabled) }
                }
            }

            biometricUseCase.executeBankAlert().collect { enabled ->
                if (enabled != null) {
                    _moreUiState.update { it.copy(isBankAlertAlertEnabled = enabled) }
                }
            }
            biometricUseCase.executeMarketContent().collect { enabled ->
                if (enabled != null) {
                    _moreUiState.update { it.copy(isMarketContentEnabled = enabled) }
                }
            }

            biometricUseCase.executeBankService().collect { enabled ->
                if (enabled != null) {
                    _moreUiState.update { it.copy(isServiceUpdateEnabled = enabled) }
                }
            }

            biometricUseCase.executeBankEvent().collect { enabled ->
                if (enabled != null) {
                    _moreUiState.update { it.copy(isEventEnabled = enabled) }
                }
            }


        }
    }

    private fun saveBiometric(isBiometricEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.execute(isBiometricEnabled  = isBiometricEnabled)
        }
    }

    private fun saveBankAlert(isMarketContentEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.executeBankAlert(isBankAlertEnabled  = isMarketContentEnabled)
        }
    }

    private fun saveServiceUpdate(isMarketContentEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.executeMarketContent(isMarketContentEnabled  = isMarketContentEnabled)
        }
    }
    private fun saveBankEvent(isMarketContentEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.executeMarketContent(isMarketContentEnabled  = isMarketContentEnabled)
        }
    }
    private fun saveMarketContent(isMarketContentEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.executeMarketContent(isMarketContentEnabled  = isMarketContentEnabled)
        }
    }
}