package com.chachadeveloper.equitymobile.feature_transaction.presentation.transaction_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Card
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
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardToolbar
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryGray
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryPink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun TransactionScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        StandardToolbar(
            navigator = navigator,
            title = "Transact",
            showForwardArrow = true

        )
        Column {
            LazyColumn{
                item {
                    Column {
                        Box(modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.TopStart)
                        {
                            Column(modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp, vertical = 20.dp)

                            ) {
                                Text(
                                    text = "What would you like to do?",
                                )
                                Spacer(modifier = Modifier.height(12.dp))

                                Card(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                    ) {
                                        Text(
                                            text = "Favourite"
                                        )
                                        Text(
                                            text = stringResource(id = R.string.favourite),
                                            maxLines = 2
                                        )
                                    }
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(20.dp)
                                    ) {
                                        Box(modifier = Modifier.fillMaxSize(),
                                            contentAlignment = Alignment.BottomEnd,
                                            ){
                                            Text(
                                                text = "Add favourite",
                                                color = primaryPink
                                            )
                                        }
                                    }

                                }
                                Spacer(modifier = Modifier.height(12.dp))

                                Text(text = "Send Money",color =  Color.White,
                                    fontSize = 18.sp)
                                        Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.fillMaxWidth()
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
                                            Column (modifier = Modifier.padding(start = 10.dp)
                                            ){
                                                Text(
                                                    text = "Own Equity account",
                                                    maxLines = 1,
                                                    style= MaterialTheme.typography.body1,
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

                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                                contentDescription =  null,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(50.dp)
                                                    .clip(CircleShape)
                                            )
                                            Column (modifier = Modifier.padding(start = 10.dp)
                                            ){
                                                Text(
                                                    text = "Another Equity account",
                                                    maxLines = 1,
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

                                        /* Row 3*/
                                        Spacer(modifier = Modifier.height(12.dp))
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                                contentDescription =  null,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(50.dp)
                                                    .clip(CircleShape)
                                            )
                                            Column (modifier = Modifier.padding(start = 10.dp)
                                            ){
                                                Text(
                                                    text = "Pay to or top up card",
                                                    maxLines = 1,
                                                )
                                                Text(
                                                    text = "credit and prepaid cards",
                                                    maxLines = 1,
                                                    style= MaterialTheme.typography.body1,
                                                    color = Color.White,
                                                    fontSize = 12.sp

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


                                        /* Row 3*/
                                        Spacer(modifier = Modifier.height(12.dp))
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                                contentDescription =  null,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(50.dp)
                                                    .clip(CircleShape)
                                            )
                                            Column(
                                                modifier = Modifier.padding(start = 10.dp)
                                            ) {
                                                Text(
                                                    text = "Mobile wallet",
                                                    maxLines = 1,
                                                    style = MaterialTheme.typography.body1,
                                                    color = Color.White
                                                )
                                                Text(
                                                    text = "send to mobile money providers",
                                                    maxLines = 1,
                                                    style = MaterialTheme.typography.body1,
                                                    color = Color.White,
                                                    fontSize = 12.sp
                                                )
                                            }
                                            Column {
                                                Box(
                                                    modifier =
                                                    Modifier.fillMaxWidth(),
                                                    contentAlignment = Alignment.CenterEnd
                                                ) {
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


                                /*Row 5*/

                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Another Bank",
                                            maxLines = 1,
                                            style = MaterialTheme.typography.body1,
                                            color = Color.White
                                        )
                                    }
                                    Column {
                                        Box(
                                            modifier =
                                            Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
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
                                            start = 0.dp,
                                            end = 0.dp
                                        )
                                )

                                Spacer(modifier = Modifier.height(12.dp))


                                Text(
                                    text = "Pay With Equity",
                                    color = Color.White
                                )

                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Pay bill",
                                            maxLines = 1,
                                            style = MaterialTheme.typography.body1,
                                            color = Color.White
                                        )
                                    }
                                    Column {
                                        Box(
                                            modifier = Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
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

                                /*Row 5*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Buy goods",
                                            maxLines = 1,
                                            style = MaterialTheme.typography.body1,
                                            color = Color.White
                                        )
                                    }
                                    Column {
                                        Box(
                                            modifier =
                                            Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
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
                                            start = 0.dp,
                                            end = 0.dp
                                        )
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(text = "Buy",
                                    color = Color.White
                                )

                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Buy airtime",
                                            maxLines = 1,
                                            style = MaterialTheme.typography.body1,
                                            color = Color.White
                                        )
                                    }
                                    Column {
                                        Box(
                                            modifier =
                                            Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
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
                                            start = 0.dp,
                                            end = 0.dp
                                        )
                                )


                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = "Withdraw cash",
                                    color = Color.White
                                )

                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Agent",
                                            maxLines = 1,
                                            style = MaterialTheme.typography.body1,
                                            color = Color.White
                                        )
                                    }
                                    Column {
                                        Box(
                                            modifier =
                                            Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
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
                                            start = 0.dp,
                                            end = 0.dp
                                        )
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }

                }
            }
        }
    }

}