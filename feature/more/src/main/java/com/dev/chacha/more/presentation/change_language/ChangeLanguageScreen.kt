package com.dev.chacha.more.presentation.change_language

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.theme.EquityMobileTheme
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeLanguageScreen() {
    var selectedOption by remember { mutableStateOf<EquityLanguage?>(null) }

    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Change Language",
                showBackArrow = true
            )
        },
        bottomBar = {
            selectedOption?.let {
                EquityButton(
                    onClick = { /*TODO*/ },
                    text = "Confirm",
                    enable = it.equals(true)
                )
            }


        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(paddingValues)
        ) {


            Text(
                text = "Choose your language",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Chagua lugha/Hitamo",
            )

            languageList.forEach { option->
                ChangeLanguageItem(
                    language =  option.language,
                    selected = selectedOption == option,
                    onSelectedLanguage = {
                        selectedOption = option
                    }

                )
            }
        }

    }

}



@Composable
fun ChangeLanguagePreview() {
    EquityMobileTheme {
        ChangeLanguageScreen()
    }
}