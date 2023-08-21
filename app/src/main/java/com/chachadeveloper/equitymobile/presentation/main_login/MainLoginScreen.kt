package com.chachadeveloper.equitymobile.presentation.main_login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.extensions.getInitials
import com.dev.chacha.extensions.greeting
import com.dev.chacha.ui.R

@Composable
@Preview(showBackground = true)
fun MainLoginScreen() {
    val myName = "Stephen Chacha"
    Scaffold(
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        /* navigator.navigate(HomeDestination)*/
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Red,
                        containerColor = Color.DarkGray
                    ),
                    shape = RoundedCornerShape(8.dp)

                ) {
                    Text(
                        text = "Let me in",
                        color = Color.Black,
                        modifier = Modifier.padding(10.dp)
                    )
                }


            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 16.dp, end = 16.dp, top = 50.dp, bottom = 18.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(MaterialTheme.colorScheme.primary, CircleShape)
                    .size(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = getInitials(myName),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(Modifier.height(16.dp))

            Text(
                text = "$greeting, Stephen",
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(20.dp))

            Text(
                text = "Password",
                color = MaterialTheme.colorScheme.onBackground
            )
            val textState = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_password_to_sign_in),
                        color = MaterialTheme.colorScheme.surface.copy(alpha = LocalContentAlpha.current)
                    )

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )
            Spacer(Modifier.height(16.dp))

            Text(
                text = "Forgot your password?",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }

    }


}