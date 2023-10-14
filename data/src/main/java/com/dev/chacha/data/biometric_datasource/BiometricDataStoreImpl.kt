package com.dev.chacha.data.biometric_datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.dev.chacha.domain.biometric_data_source.BiometricDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.biometricDataStore: DataStore<Preferences> by preferencesDataStore(name = "biometric_settings")

class BiometricDataStoreImpl @Inject constructor(private val context: Context): BiometricDataStore {

    private val dataStore = context.biometricDataStore

    override val isBiometricEnabled: Flow<Boolean> = dataStore.data.map { preferences ->
            preferences[KEY_IS_BIOMETRIC] ?: false
        }

    override suspend fun saveBiometric(isBiometricEnabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[KEY_IS_BIOMETRIC] = isBiometricEnabled
        }

    }

    override val isBankAlertEnabled: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[KEY_IS_BANK_ALERT] ?: false
    }

    override suspend fun saveBankAlert(isBankAlertEnabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[KEY_IS_BANK_ALERT] = isBankAlertEnabled
        }

    }

    override val isBankEventEnabled: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[KEY_IS_BANK_EVENT] ?: false
    }

    override suspend fun saveBankEvent(isBankEventEnabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[KEY_IS_BANK_EVENT] = isBankEventEnabled
        }

    }

    override val isMarketContentEnabled: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[KEY_IS_MARKET_CONTENT] ?: false
    }

    override suspend fun saveMarketContent(isMarketContentEnabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[KEY_IS_MARKET_CONTENT] = isMarketContentEnabled
        }

    }

    override val isServiceUpdateEnabled: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[KEY_IS_SERVICE_UPDATE] ?: false
    }

    override suspend fun saveServiceUpdate(isServiceUpdateEnabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[KEY_IS_SERVICE_UPDATE] = isServiceUpdateEnabled
        }

    }


    companion object{
        private val KEY_IS_BIOMETRIC = booleanPreferencesKey("biometric_enabled")
        private val KEY_IS_BANK_EVENT = booleanPreferencesKey("bank_enabled")
        private val KEY_IS_BANK_ALERT = booleanPreferencesKey("bank_alert_enabled")
        private val KEY_IS_SERVICE_UPDATE= booleanPreferencesKey("service_enabled")
        private val KEY_IS_MARKET_CONTENT = booleanPreferencesKey("market_enabled")

    }

}