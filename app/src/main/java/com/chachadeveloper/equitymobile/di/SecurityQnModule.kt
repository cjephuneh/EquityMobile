package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.feature_auth.presentation.login_screen.LoginViewModel
import com.chachadeveloper.equitymobile.feature_auth.presentation.security_qsn_screen.SecurityQnViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val securityQnModule = module {
    viewModel { SecurityQnViewModel() }
}