package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.presentation.reset_password_screen.ResetPasswordViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val resetPasswordModule = module {
    viewModel { ResetPasswordViewModel() }
}