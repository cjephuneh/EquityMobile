package com.dev.chacha.more.presentation.manage_pin_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.dev.chacha.ui.common.theme.primaryGray
import com.dev.chacha.ui.common.theme.primaryPink

import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun MangePin() {

    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            title = "Mange Pin",
            showForwardArrow = true,
            showBackArrow = true
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                /* Other cards */
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
                        colorFilter = ColorFilter.tint(color =primaryPink)

                    )
                    Column(modifier = Modifier.padding(start = 10.dp)) {
                        Text(
                            text = "Change your PIN",
                            maxLines = 1,

                            )
                        Text(
                            text = "Change your existing PIN",
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
                            start = 60.dp,
                            end = 8.dp
                        )
                )

                Spacer(modifier = Modifier.height(12.dp))
                /* Pay my Loan*/

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
                        colorFilter = ColorFilter.tint(color =primaryPink)

                    )
                    Column(modifier = Modifier.padding(start = 10.dp)) {
                        Text(
                            text = "Reset your PIN",
                            maxLines = 1,

                            )
                        Text(
                            text = "Reset your PIN if you've forgotten it",
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
                            start = 60.dp,
                            end = 8.dp
                        )
                )

            }
        }

    }

}