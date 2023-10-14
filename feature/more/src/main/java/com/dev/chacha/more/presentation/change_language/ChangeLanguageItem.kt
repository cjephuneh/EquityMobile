package com.dev.chacha.more.presentation.change_language

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.Language

@Composable
fun ChangeLanguageItem(
    language: String,
    selected: Boolean = false,
    onSelectedLanguage:()->Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected =  selected,
            onClick = { onSelectedLanguage()}
        )
        Text(
            text = language,
            modifier = Modifier.weight(1f)
                .padding(horizontal = 10.dp)
        )
    }
}

data class EquityLanguage(
    val language: String
)

val languageList = listOf(
    EquityLanguage(
        "English"
    ),
    EquityLanguage(
        "Swahili"
    ),

    EquityLanguage(
        "French"
    ),
    EquityLanguage(
        "Kinyarwanda"
    )
)