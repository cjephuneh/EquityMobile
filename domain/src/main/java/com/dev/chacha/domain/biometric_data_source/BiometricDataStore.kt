package com.dev.chacha.domain.biometric_data_source

import kotlinx.coroutines.flow.Flow

interface BiometricDataStore {
    val isBiometricEnabled: Flow<Boolean?>
    suspend fun saveBiometric(isBiometricEnabled: Boolean)

    val isBankAlertEnabled: Flow<Boolean?>
    suspend fun saveBankAlert(isBankAlertEnabled: Boolean)

    val isBankEventEnabled: Flow<Boolean?>
    suspend fun saveBankEvent(isBankEventEnabled: Boolean)

    val isMarketContentEnabled: Flow<Boolean?>
    suspend fun saveMarketContent(isMarketContentEnabled: Boolean)

    val isServiceUpdateEnabled: Flow<Boolean?>
    suspend fun saveServiceUpdate(isServiceUpdateEnabled: Boolean)
}
