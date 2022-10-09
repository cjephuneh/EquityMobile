package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.feature_auth.presentation.login_screen.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel { LoginViewModel() }
}