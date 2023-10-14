package com.dev.chacha.ui.common.device_info

import android.os.Build
import android.telephony.TelephonyManager
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import android.provider.Settings



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


@Composable
fun DeviceInfoComponent() {
    val deviceInfo = getDeviceInfo() // Fetch device information

    Column {
        Text("Device ID: ${deviceInfo.id}")
        Text("Device Type: ${deviceInfo.type}")
    }
}



