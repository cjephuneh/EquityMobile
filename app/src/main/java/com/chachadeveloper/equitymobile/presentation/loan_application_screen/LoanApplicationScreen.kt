package com.chachadeveloper.equitymobile.presentation.loan_application_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterBAndW
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.destinations.GetLoanScreenDestination
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@com.ramcosta.composedestinations.annotation.Destination
fun LoanApplicationScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navigator = navigator,
            title = "Get Loan",
            showBackArrow = true
        )
      /*  CustomToolbar(
            navigator = navigator,
            showBackArrow = true,
            modifier = Modifier.fillMaxSize(),
            title = {
                Text(
                    text = "Get Loan",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body1
                )
            }
        )*/
        Column {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp, end = 30.dp)) {

                    Text(
                        text = "Apply for a Loan",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.loanDesc) ,
                        maxLines = 2
                    )
                    Spacer(modifier = Modifier.height(25.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp)
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.FilterBAndW,
                                contentDescription = null
                            )
                        }
                        Text(text = "Filter by",
                            textAlign = TextAlign.Center
                        )
                    }
                    Column(horizontalAlignment = Alignment.Start) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .width(30.dp)
                                .height(15.dp)
                        ) {
                            Text(
                                text = "Instant",
                                color = Color.White
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp)
                        ) {
                            Text(
                                text = "General purpose Loan",
                                color = Color.White)

                            Text(
                                text = stringResource(id = R.string.purpose),
                                    maxLines = 2
                            )

                        }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(10.dp),
                                contentAlignment = Alignment.BottomEnd,

                                ) {
//                                Text(text = "Add favourite")
                                Row {
                                    Text(
                                        text = "Learn more_screen",
                                        color = primaryPink,
                                        modifier = Modifier.clickable {
                                            navigator.navigate(GetLoanScreenDestination)
                                        },
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))

                                    Button(
                                        onClick = {
                                            navigator.navigate(GetLoanScreenDestination)
                                        },
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(40.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = primaryPink
                                        )
                                    ) {
                                        Text(
                                            text = "Apply now",
                                            )
                                    }
                                }

                            }
                        }
                    }
                }

            }
        }
    }

}