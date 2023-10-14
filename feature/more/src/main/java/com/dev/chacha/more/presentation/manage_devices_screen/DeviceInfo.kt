package com.dev.chacha.more.presentation.manage_devices_screen

import android.os.Build
import android.provider.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


/*
data class DeviceInfo(val id: String, val type: String)

@Composable
fun getDeviceInfo(): DeviceInfo {
    val context = LocalContext.current

    val deviceId = Settings.Secure.getString(
        context.contentResolver,
        Settings.Secure.ANDROID_ID
    )

    val deviceType = "${Build.MANUFACTURER} ${Build.MODEL}"

    return DeviceInfo(deviceId, deviceType)
}
*/
