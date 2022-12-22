package com.chachadeveloper.equitymobile.feature_loan.presentation.borrow_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardToolbar
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryGray
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryPink
import com.chachadeveloper.equitymobile.destinations.LoanApplicationScreenDestination
import com.chachadeveloper.equitymobile.destinations.PayLoanScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun BorrowScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navigator = navigator,
            title = "Borrow",
            showForwardArrow = true,
        )
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp)
            ){

                Text(
                    text = "What would you like to do",
                    color = Color.White,
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = stringResource(id = R.string.loans),
                    style =  MaterialTheme.typography.body2,
                    maxLines = 2,
                    color = Color.White
                )

                /* Other cards */

                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().clickable {
                        navigator.navigate(LoanApplicationScreenDestination)
                    }
                ) {

                    Image(
                        painter =
                        painterResource(id = R.drawable.ic_support_foreground) ,
                        contentDescription =  null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color.DarkGray),
                        colorFilter = ColorFilter.tint(color = primaryPink)

                    )
                    Column(modifier = Modifier.padding(start = 10.dp)){
                        Text(
                            text = "Get Loan",
                            maxLines = 1,
                            style= MaterialTheme.typography.body1,
                            color = Color.White
                        )

                    }
                    Column {
                        Box(modifier =
                        Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd
                        ){
                            Icon(
                                painter =
                                painterResource(id = R.drawable.ic_chevron_right),
                                tint = primaryPink,
                                contentDescription = null,

                                )
                        }
                    }

                }
                Spacer(modifier = Modifier.height(12.dp))
                Divider(
                    color = primaryGray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(
                            start = 60.dp,
                            end = 8.dp
                        )
                )
                Spacer(modifier = Modifier.height(12.dp))
                /* Pay my Loan*/

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().clickable {
                        navigator.navigate(PayLoanScreenDestination)
                    }
                ) {

                    Image(
                        painter =
                        painterResource(id = R.drawable.ic_support_foreground) ,
                        contentDescription =  null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color.DarkGray),
                        colorFilter = ColorFilter.tint(color = primaryPink)

                    )
                    Column(modifier = Modifier.padding(start = 10.dp)){
                        Text(
                            text = "Pay Loan",
                            maxLines = 1,
                            style= MaterialTheme.typography.body1,
                            color = Color.White
                        )

                    }
                    Column {
                        Box(modifier =
                        Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd
                        ){
                            Icon(
                                painter =
                                painterResource(id = R.drawable.ic_chevron_right),
                                tint = primaryPink,
                                contentDescription = null,

                                )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }

    }

}