package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.core.data.repository.DataStoreRepository
import org.koin.dsl.module

val appModule = module {
    single { DataStoreRepository(get()) }
}