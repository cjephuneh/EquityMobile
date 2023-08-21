package com.dev.chacha.more.presentation.notification_screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun NotificationPreferencesListItem(
    @StringRes title: Int,
    @StringRes subtitle: Int,
    isUpdated: Boolean = false,
) {
    Column (modifier = Modifier.fillMaxWidth()){
        Text(text = stringResource(id = title))
        Row {

        }

    }

}