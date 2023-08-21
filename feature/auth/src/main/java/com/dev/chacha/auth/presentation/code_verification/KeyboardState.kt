package com.dev.chacha.auth.presentation.code_verification

import android.graphics.Rect
import android.view.ViewTreeObserver
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
enum class KeyboardState {
    Opened,
    Closed
}

@Composable
fun keyboardAsState(initial: KeyboardState = KeyboardState.Closed): State<KeyboardState> {
    val keyboardState = remember {
        mutableStateOf(initial)
    }
    val view = LocalView.current
    DisposableEffect(view) {
        val onGlobalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
            val rect = Rect()
            view.getWindowVisibleDisplayFrame(rect)
            val screenHeight = view.rootView.height
            val keypadHeight = screenHeight - rect.bottom
            keyboardState.value = if (keypadHeight > screenHeight * 0.15) {
                KeyboardState.Closed
            } else {
                KeyboardState.Opened
            }
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener)
        }
    }
    return keyboardState // Return the mutableStateOf directly, not by calling the function again
}
