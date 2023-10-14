package com.dev.chacha.data.di

import android.content.Context
import com.dev.chacha.data.biometric_datasource.BiometricDataStoreImpl
import com.dev.chacha.domain.biometric_data_source.BiometricDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BiometricModule {

    @Singleton
    @Provides
    fun provideBiometricDataStore(@ApplicationContext context: Context): BiometricDataStore {
        return BiometricDataStoreImpl(context = context)
    }

}