package com.chachadeveloper.equitymobile.feature_more.presentation.change_language_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardToolbar
import com.chachadeveloper.equitymobile.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@com.ramcosta.composedestinations.annotation.Destination
fun ChangeLanguageScreen(navigator: DestinationsNavigator) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolbar(
            navigator = navigator,
            title = "Change Password",
            showBackArrow = true
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
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ){

                Button(
                    onClick = {
                        navigator.navigate(HomeScreenDestination)
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