package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.presentation.changeResetPIN.ResetPinViewModel
import com.chachadeveloper.equitymobile.presentation.createPin.CreatePinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val resetPinModule = module {
    viewModel { ResetPinViewModel() }
}