package com.chachadeveloper.equitymobile.core.presentation.main_login_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonPinCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun MainLoginScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ){
                Column (
                    modifier = Modifier.fillMaxSize()
                        .padding(start = 30.dp, end = 30.dp),
                      horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        imageVector = Icons.Filled.PersonPinCircle,
                        contentDescription =  null
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "Good morning, Stephen", color = Color.White)
                    Spacer(modifier = Modifier.height(10.dp))


                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(text = "Password", color = Color.White)
                        Spacer(modifier = Modifier.height(10.dp))

                        val textState = remember { mutableStateOf(TextFieldValue()) }
                        TextField(
                            value = textState.value,
                            onValueChange = { textState.value = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(20.dp))


                        Text(
                            text = "Forget password",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = primaryPink
                        )

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Bottom
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

                                ) {
                                Text(
                                    text = "Let me in",
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                        }

                    }



                }


            }
        }

    }

}