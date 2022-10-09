package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.feature_transaction.presentation.create_pin_screen.CreatePinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val createPinModule = module {
    viewModel { CreatePinViewModel() }
}