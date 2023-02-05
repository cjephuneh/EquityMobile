package com.dev.chacha.more.presentation.notification_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryGray
import com.dev.chacha.ui.common.theme.primaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationPreferences() {
    Column(modifier = Modifier.fillMaxSize()) {
    StandardToolbar(
            showBackArrow = true,
            title = "Notification Preference"
        )

        Column(verticalArrangement = Arrangement.Top) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    Text(
                        text = "Set your notification_screen preferences",
                        maxLines = 1,


                        )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = "Select which notifications you would like to receive",
                        maxLines = 1,
                    )


                    /* Other cards */

                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column {
                            Text(
                                text = "Service update",
                                maxLines = 1,
                                color = Color.White
                            )
                            Text(
                                text = " Get alerts about any upgrade,outages or schedule downtime",
                                maxLines = 2,
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
                                    tint =primaryPink,
                                    contentDescription = null,

                                    )

                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(
                        color =primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                end = 0.dp
                            )
                    )


                    Spacer(modifier = Modifier.height(12.dp))


                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column {
                            Text(
                                text = "Reminders",
                                maxLines = 1,
                            )
                            Text(
                                text = "get notified when your schedule payment are coming up",
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
                                    tint =primaryPink,
                                    contentDescription = null,

                                    )

                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(
                        color =primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                end = 0.dp
                            )
                    )


                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column {
                            Text(
                                text = "Bank account alters",
                                maxLines = 1,
                            )
                            Text(
                                text = "Get important update about your bankaccessor cards",
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
                                    tint =primaryPink,
                                    contentDescription = null,

                                    )

                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(
                        color =primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                end = 0.dp
                            )
                    )


                    Spacer(modifier = Modifier.height(12.dp))


                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = "Marketing content",
                                maxLines = 1,
                            )
                            Text(
                                text = "We'll let you know about new product to promotion",
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
                                    tint =primaryPink,
                                    contentDescription = null,

                                    )

                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(
                        color =primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                end = 0.dp
                            )
                    )


                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column {
                            Text(
                                text = "Events",
                                maxLines = 1,

                                )
                            Text(
                                text = "Get notified about any upcominging important events",
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
                                    tint =primaryPink,
                                    contentDescription = null,

                                    )

                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(
                        color =primaryGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(
                                start = 0.dp,
                                end = 0.dp
                            )
                    )


                }


            }
        }

    }


}