package com.dev.chacha.auth.presentation.security_screen

import android.content.res.Configuration
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryGray
import com.dev.chacha.ui.common.theme.primaryPink


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecurityScreen() {
    Scaffold(
        topBar = {
            StandardToolbar(
                showBackArrow = true,
                title = "Security Questions"
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 20.dp, end = 20.dp)


        ) {

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
                        text = "Change Password",
                        maxLines = 1,
                    )
                    Text(
                        text = "create a new password",
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
                        text = "Manage your PIN",
                        maxLines = 1,
                    )
                    Text(
                        text = "Reset or change your PIN",
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
                        text = "Manage security_screen questions",
                        maxLines = 1,
                        color = Color.White
                    )
                    Text(
                        text = "Update your security_screen suggestion",
                        maxLines = 1,
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
                        text = "Enable touch ID",
                        maxLines = 1,
                        color = Color.White
                    )
                    Text(
                        text = "Unlock with Touch ID",
                        maxLines = 1,
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
                        text = "Managed your device",
                        maxLines = 1,

                        )
                    Text(
                        text = "Manage the devices connected to your profile",
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

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        SecurityScreen()
    }

}





