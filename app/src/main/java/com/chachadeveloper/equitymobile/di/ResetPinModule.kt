package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.presentation.reset_pin_screen.ResetPinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val resetPinModule = module {
    viewModel { ResetPinViewModel() }
}