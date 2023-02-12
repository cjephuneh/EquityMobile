package com.dev.chacha.more.presentation.change_language_screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
                .padding(paddingValues)
                .padding(16.dp)
        ) {



                Text(text = "Choose your language")
                Text(text = "Chagua lugha/Hitamo")

                Row(modifier = Modifier.fillMaxWidth()) {

                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = null
                    )
                    Text(text = "English")
                }
                Row(modifier = Modifier.fillMaxWidth()) {

                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null
                    )
                    Text(text = "Swahili")
                }


                Row(modifier = Modifier.fillMaxWidth()) {

                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null
                    )

                    Text(text = "French")

                }

                Row(modifier = Modifier.fillMaxWidth()) {
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