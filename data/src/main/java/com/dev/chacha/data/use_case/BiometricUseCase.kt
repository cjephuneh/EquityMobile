package com.dev.chacha.data.use_case

import com.dev.chacha.domain.biometric_data_source.BiometricDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BiometricUseCase  @Inject constructor(
    private val biometricDataStore: BiometricDataStore
) {

    fun execute(): Flow<Boolean?> {
        return biometricDataStore.isBiometricEnabled
    }
    suspend fun execute(isBiometricEnabled:  Boolean) {
        biometricDataStore.saveBiometric(isBiometricEnabled  = isBiometricEnabled)
    }

    fun executeBankAlert(): Flow<Boolean?> {
        return biometricDataStore.isBankAlertEnabled
    }

    suspend fun executeBankAlert(isBankAlertEnabled:  Boolean) {
        biometricDataStore.saveBankAlert(isBankAlertEnabled  = isBankAlertEnabled)
    }

    fun executeBankEvent(): Flow<Boolean?> {
        return biometricDataStore.isBankEventEnabled
    }

    suspend fun executeBankEvent(isBankEventEnabled:  Boolean) {
        biometricDataStore.saveBankEvent(isBankEventEnabled  = isBankEventEnabled)
    }

    fun executeMarketContent(): Flow<Boolean?> {
        return biometricDataStore.isMarketContentEnabled
    }

    suspend fun executeMarketContent(isMarketContentEnabled:  Boolean) {
        biometricDataStore.saveMarketContent(isMarketContentEnabled  = isMarketContentEnabled)
    }

    fun executeBankService(): Flow<Boolean?> {
        return biometricDataStore.isServiceUpdateEnabled
    }
    suspend fun executeServiceUpdate(isServiceUpdateEnabled:  Boolean) {
        biometricDataStore.saveServiceUpdate(isServiceUpdateEnabled  = isServiceUpdateEnabled)
    }


}