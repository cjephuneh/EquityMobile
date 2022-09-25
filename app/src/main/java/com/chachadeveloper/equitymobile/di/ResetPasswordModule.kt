package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.presentation.changeResetPassword.ResetPasswordViewModel
import com.chachadeveloper.equitymobile.presentation.createPin.CreatePinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val resetPasswordModule = module {
    viewModel { ResetPasswordViewModel() }
}