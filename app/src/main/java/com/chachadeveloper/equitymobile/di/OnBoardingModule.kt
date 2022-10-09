package com.chachadeveloper.equitymobile.di

import com.chachadeveloper.equitymobile.presentation.onboarding_screen.OnBoardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onboardingModule = module {
    viewModel { OnBoardingViewModel(get()) }
}