package com.dev.chacha.more.presentation.more_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryGray
import com.dev.chacha.ui.common.theme.primaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MoreScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "More",
                showForwardArrow = true,
                showBackArrow = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 12.dp)
                            ) {
                                Text(
                                    text = "Stephen Chacha",
                                    maxLines = 1,
                                )
                                Spacer(modifier = Modifier.height(1.dp))
                                Text(
                                    text = "stevechacha4@gmail.com",
                                    maxLines = 1,
                                )
                                Spacer(modifier = Modifier.height(1.dp))
                                Text(
                                    text = "254746656813",
                                    maxLines = 1,
                                )
                            }

                        }

                    }

                    /* Other cards */
                    Spacer(modifier = Modifier.height(18.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                            }
                    ) {
                        Image(
                            painter =
                            painterResource(id = R.drawable.ic_notifications_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Notifications",
                                maxLines = 1,
                            )
                            Text(
                                text = "View and manage notification_screen",
                                maxLines = 1,
                                fontSize = 10.sp,

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
                    Spacer(modifier = Modifier.height(15.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp
                            )
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                            }
                    ) {

                        Image(
                            painter =
                            painterResource(id = R.drawable.ic_security_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Security",
                                maxLines = 1,

                                )
                            Text(
                                text = "Change your sign-in details and password",
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
                    Spacer(modifier = Modifier.height(15.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp
                            )
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                            }
                    ) {

                        Image(
                            painter =
                            painterResource(id = R.drawable.ic_support_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Support",
                                maxLines = 1,
                            )
                            Text(
                                text = "Email, call or find us on social media",
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
                    Spacer(modifier = Modifier.height(15.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp
                            )
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                            }
                    ) {

                        Image(
                            painter =
                            painterResource(id = R.drawable.ic_support_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)
                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Change language",
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
                    Spacer(modifier = Modifier.height(15.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp
                            )
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Image(
                            painter =
                            painterResource(id = R.drawable.ic_support_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Recommend Equity mobile to a friend",
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
                    Spacer(modifier = Modifier.height(15.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp
                            )
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Image(
                            painter =
                            painterResource(id = R.drawable.ic_signout_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.DarkGray),
                            colorFilter = ColorFilter.tint(color = primaryPink)

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Sign out",
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
                    Spacer(modifier = Modifier.height(15.dp))
                    Divider(
                        color = primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp
                            )
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Version 0.0.67",
                        color = Color.DarkGray,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                }
            }
        }

    }


}