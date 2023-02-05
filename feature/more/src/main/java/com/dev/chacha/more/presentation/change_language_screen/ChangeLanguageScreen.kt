package com.dev.chacha.more.presentation.change_language_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeLanguageScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolbar(
            title = "Change Password",
            showBackArrow = true
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp, end = 30.dp)
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