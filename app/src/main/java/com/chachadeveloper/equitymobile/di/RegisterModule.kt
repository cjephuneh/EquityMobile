package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.feature_auth.presentation.register_screen.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registerModule = module {

    viewModel { RegisterViewModel() }
}