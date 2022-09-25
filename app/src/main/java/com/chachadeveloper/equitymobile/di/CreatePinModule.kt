package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.presentation.createPin.CreatePinViewModel
import com.chachadeveloper.equitymobile.presentation.login.LoginViewModel
import com.chachadeveloper.equitymobile.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.converter.moshi.MoshiConverterFactory

val createPinModule = module {
    viewModel { CreatePinViewModel() }
}