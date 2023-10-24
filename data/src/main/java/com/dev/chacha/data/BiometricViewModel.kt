package com.dev.chacha.data

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
class BiometricViewModel  @Inject constructor(
    private val biometricUseCase: BiometricUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(BiometricUiState())
    val uiState: StateFlow<BiometricUiState> = _uiState


    init {
        getBiometric()
    }


    fun onEvent(event: BiometricUiEvent){
        when(event){
            is BiometricUiEvent.EnableBiometricToggled -> {
                saveBiometric(isBiometricEnabled  = event.isBiometricEnabled)
                getBiometric()
            }

        }
    }

    private fun getBiometric() {
        viewModelScope.launch {
            biometricUseCase.execute().collect { isBiometricEnabled ->
                if (isBiometricEnabled != null) {
                    _uiState.update { it.copy(isBiometricEnabled  = isBiometricEnabled) }
                }
            }
        }
    }

    private fun saveBiometric(isBiometricEnabled: Boolean) {
        viewModelScope.launch {
            biometricUseCase.execute(isBiometricEnabled  = isBiometricEnabled)
        }
    }
}