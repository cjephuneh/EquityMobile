package com.chachadeveloper.equitymobile

import android.app.Application
import com.chachadeveloper.equitymobile.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class EquityMobileApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@EquityMobileApp)
            modules(
                apiModule,
                environmentModule,
                networkModule,
                loginModule,
                registerModule,
                createPasswordModule,
                createPinModule,
                appModule,
                onboardingModule,
                resetPasswordModule,
                resetPinModule,
                securityQnModule

            )
        }
    }
}