package com.dev.chacha.more.presentation.support_scrren

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryGray
import com.dev.chacha.ui.common.theme.primaryPink


@Composable
fun SupportScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Support",
                showBackArrow = true,
                showForwardArrow = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top
        ) {
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
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = stringResource(id = R.string.getInTouch),
                        maxLines = 2,
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

                                )
                            Text(
                                text = "+254763000000",
                                maxLines = 1,
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

                                )
                            Text(
                                text = "info@equitybank@co.ke",
                                maxLines = 1,
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
                            )
                            Text(
                                text = "https://equityholdings.com/ke",
                                maxLines = 1,
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
                            )
                            Text(
                                text = "KeEquityBank",
                                maxLines = 1,
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
                            )
                            Text(
                                text = "https://www.facebook.com/KeEquityBank/",
                                maxLines = 1,

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
                            )
                            Text(
                                text = "Equity Bank Limited",
                                maxLines = 1,
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

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        SupportScreen()
    }

}
