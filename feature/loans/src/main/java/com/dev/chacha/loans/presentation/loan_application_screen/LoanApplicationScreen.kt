package com.dev.chacha.loans.presentation.loan_application_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryPink


@Composable
fun LoanApplicationScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            title = "Get Loan",
            showBackArrow = true
        )
        Column {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 25.dp, end = 25.dp)
                ) {

                    Text(
                        text = "Apply for a Loan",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.loanDesc),
                        maxLines = 2
                    )
                    Spacer(modifier = Modifier.height(25.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = null
                            )
                        }
                        Text(
                            text = "Filter by",
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
                            )

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
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Learn more screen",
                                        color = primaryPink,
                                        modifier = Modifier.clickable {
                                        },
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))

                                    Button(
                                        onClick = {
                                        },
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(40.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = primaryPink
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