package com.chachadeveloper.equitymobile.presentation.changeLanguage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.destinations.Destination
import com.chachadeveloper.equitymobile.presentation.destinations.HomeDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@com.ramcosta.composedestinations.annotation.Destination
fun ChangeLanguage(navigator: DestinationsNavigator) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolbar(
            navigator = navigator,
            title = {
                Text(
                    text = "Create Password",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body2
                )
            }
        )


        Column (modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp)
        ) {


            Text(text = "Choose your language")
            Text(text = "Chagua lugha/Hitamo")

            Row(modifier = Modifier.fillMaxWidth()) {

                Icon(imageVector = Icons.Filled.Language,
                    contentDescription = null
                )

                Text(text = "English")

            }

            Row(modifier = Modifier.fillMaxWidth()) {

                Icon(imageVector = Icons.Filled.Language,
                    contentDescription = null
                )

                Text(text = "Swahili")

            }


            Row(modifier = Modifier.fillMaxWidth()) {

                Icon(imageVector = Icons.Filled.Language,
                    contentDescription = null
                )

                Text(text = "French")

            }

            Row(modifier = Modifier.fillMaxWidth()) {
                var selected: Boolean = false

                RadioButton(selected,
                    onClick = {
                        selected =!selected
                    })

                Text(text = "Kinyarwanda")



            }


            Column (
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ){

                Button(
                    onClick = {
                        navigator.navigate(HomeDestination)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Red,
                        backgroundColor = Color.DarkGray
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