package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.presentation.create_password_screen.CreatePasswordViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val createPasswordModule = module {
    viewModel { CreatePasswordViewModel() }
}