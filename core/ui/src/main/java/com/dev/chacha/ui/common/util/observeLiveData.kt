package com.dev.chacha.ui.common.util

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

@Composable
fun <T> observeLiveData(data: MutableLiveData<T>, callback: Observer<T>) {
    val lifecycleOwner by rememberUpdatedState(LocalLifecycleOwner.current)

    DisposableEffect(lifecycleOwner) {
        data.observeForever(callback)

        onDispose {
            data.removeObserver(callback)
        }
    }
}