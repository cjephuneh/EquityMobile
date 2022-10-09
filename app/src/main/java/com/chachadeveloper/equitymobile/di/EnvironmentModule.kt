package com.chachadeveloper.equitymobile.di


import com.chachadeveloper.equitymobile.core.util.Environment
import org.koin.dsl.module

val environmentModule = module {
    single<Environment> { Environment.Main }
}