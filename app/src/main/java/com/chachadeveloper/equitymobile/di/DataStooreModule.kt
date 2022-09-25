package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.data.repository.DataStoreRepository
import org.koin.dsl.module

val appModule = module {
    single { DataStoreRepository(get()) }
}