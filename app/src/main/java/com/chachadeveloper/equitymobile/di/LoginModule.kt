package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.converter.moshi.MoshiConverterFactory

val loginModule = module {
    viewModel { LoginViewModel() }
}