package com.dev.chacha.auth.presentation.biometric

import android.Manifest
import android.app.KeyguardManager
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.CancellationSignal
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.dev.chacha.auth.presentation.navigation.AuthScreen
import timber.log.Timber

@RequiresApi(Build.VERSION_CODES.P)
class BiometricChecker(
    private val authListener: AuthListener,
    val navController: NavController,
    val activity: FragmentActivity
): BiometricPrompt.AuthenticationCallback() {

    private var cancellationSignal: CancellationSignal? = null

    private val authenticationCallback =
    object : BiometricPrompt.AuthenticationCallback() {
        override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
            notifyUser("Authentication Error $errorCode")
            super.onAuthenticationError(errorCode, errString)
        }

        override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
            super.onAuthenticationHelp(helpCode, helpString)
        }

        override fun onAuthenticationFailed() {
            super.onAuthenticationFailed()

        }

        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
            notifyUser("Authentication Succeeded")
            super.onAuthenticationSucceeded(result)

            navController.navigate(AuthScreen.MainLogin.route)


        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun authenticate() {
        if (checkBiometricSupport()) {
            val biometricPrompt = BiometricPrompt
                .Builder(activity)
                .setTitle("Equity mobile")
                .setSubtitle("Touch ID is required to sign")
                .setDescription("Scan your fingerprint")
                .setNegativeButton("CANCEL", activity.mainExecutor) { _, _ ->
                    notifyUser("Authentication cancelled")

                }
                .build()

            biometricPrompt.authenticate(
                getCancellationSignal(),
                activity.mainExecutor,
                authenticationCallback
            )
        }
    }

    private fun checkBiometricSupport(): Boolean {
        val keyguardManager = activity.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

        if (!keyguardManager.isDeviceSecure) {
            notifyUser("lock screen security not enabled in the setting")
            return false
        }
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.USE_BIOMETRIC) != PackageManager.PERMISSION_GRANTED) {
            notifyUser("Finger print authentication permission not enabled")
            return false
        }
        return activity.packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)
    }

    private fun getCancellationSignal(): CancellationSignal {
        cancellationSignal = CancellationSignal()
        cancellationSignal?.setOnCancelListener {
            notifyUser("Auth Cancelled via Signal")
        }

        return cancellationSignal as CancellationSignal
    }

    private fun notifyUser(message: String) {
        Timber.tag("BIOMETRIC").d(message)
    }

    interface AuthListener {
        fun onAuthSuccess(message: String)
        fun onAuthError(error: String)
    }


}