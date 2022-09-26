package com.chachadeveloper.equitymobile.presentation.support

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.ui.theme.primaryGray
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun Support(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navigator = navigator,
            title = {
                Text(
                    text = "Get in touch",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body1
                )
            },
            navActions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.chat_icon),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(color = Color.White)
                    )
                }
            }
        )

        Column(verticalArrangement = Arrangement.Top) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 30.dp, end = 30.dp)
                ) {

                    Text(
                        text = "How can we help you?",
                        maxLines = 1,
                        style = MaterialTheme.typography.body2,
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = stringResource(id = R.string.getInTouch),
                        maxLines = 2,
                        style = MaterialTheme.typography.body2,
                    )

                    /* Other cards */
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter =
                            painterResource(id = R.drawable.ic_phone_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Call us",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "+254763000000",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
                            )
                        }
                        Column {
                            Box(
                                modifier =
                                Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_chevron_right),
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
                                start = 8.dp,
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
                            painter =
                            painterResource(id = android.R.drawable.ic_dialog_email),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Email",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "info@equitybank@co.ke",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
                            )
                        }
                        Column {
                            Box(
                                modifier =
                                Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_chevron_right),
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
                                start = 8.dp,
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
                            painter = painterResource(id = R.drawable.ic_support_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Visit our website",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "https://equityholdings.com/ke",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
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
                                start = 8.dp,
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
                            painter =
                            painterResource(id = R.drawable.ic_twitter),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Follow us on Twitter",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "KeEquityBank",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
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
                                start = 8.dp,
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
                            painter =
                            painterResource(id = R.drawable.ic__facebook),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Like us on Facebook",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "https://www.facebook.com/KeEquityBank/",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
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
                                start = 8.dp,
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
                            painter =
                            painterResource(id = R.drawable.ic__linkedin),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Follow us on LinkedIn",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "Equity Bank Limited",
                                maxLines = 1,
                                style = MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
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
                                start = 8.dp,
                                end = 8.dp
                            )
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}