package com.chachadeveloper.equitymobile.feature_loan.presentation.loan_application_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterBAndW
import androidx.compose.material3.*
import androidx.compose.material3.Button
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
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardToolbar
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryPink
import com.chachadeveloper.equitymobile.destinations.GetLoanScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@com.ramcosta.composedestinations.annotation.Destination
fun LoanApplicationScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navigator = navigator,
            title = "Get Loan",
            showBackArrow = true
        )
        Column {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 25.dp, end = 25.dp)) {

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
                            .padding(start = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
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
                                Row (
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Text(
                                        text = "Learn more screen",
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