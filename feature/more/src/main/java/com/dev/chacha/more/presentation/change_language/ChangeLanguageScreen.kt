package com.dev.chacha.more.presentation.change_language

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeLanguageScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Change Language",
                showBackArrow = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .padding(paddingValues)
        ) {


            Text(
                text = "Choose your language",
                modifier = Modifier.padding(start = 10.dp)
            )
            Text(
                text = "Chagua lugha/Hitamo",
                modifier = Modifier.padding(start = 10.dp)

            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var selected: Boolean = false

                RadioButton(selected,
                    onClick = {
                        selected = !selected
                    })

                Text(text = "Kinyarwanda")

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var selected: Boolean = false

                RadioButton(selected,
                    onClick = {
                        selected = !selected
                    })

                Text(text = "Kinyarwanda")

            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var selected: Boolean = false

                RadioButton(selected,
                    onClick = {
                        selected = !selected
                    })

                Text(text = "Kinyarwanda")

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var selected: Boolean = false

                RadioButton(selected,
                    onClick = {
                        selected = !selected
                    })

                Text(text = "Kinyarwanda")

            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {

                Button(
                    onClick = {
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Red,
                        containerColor = Color.DarkGray
                    ),
                    shape = RoundedCornerShape(8.dp)

                ) {
                    Text(
                        text = "Confirm",
                        color = Color.Black,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

            }

        }

    }

}

@Composable
@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun ChangeLanguagePreview() {
    EquityMobileTheme {
        ChangeLanguageScreen()
    }
}