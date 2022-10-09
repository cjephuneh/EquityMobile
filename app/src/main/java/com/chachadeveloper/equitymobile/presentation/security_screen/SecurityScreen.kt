package com.chachadeveloper.equitymobile.presentation.security_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.destinations.ManageDeviceScreenDestination
import com.chachadeveloper.equitymobile.presentation.destinations.ManageSecurityQnScreenDestination
import com.chachadeveloper.equitymobile.presentation.destinations.ResetPasswordScreenDestination
import com.chachadeveloper.equitymobile.ui.theme.primaryGray
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@Destination
fun SecurityScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navigator = navigator,
            showBackArrow = true,
            title = "Security Questions"
        )

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
                        navigator.navigate(ResetPasswordScreenDestination)
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
                        style = MaterialTheme.typography.body1,
                        color = Color.White
                    )
                    Text(
                        text = "create a new password",
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
                        style = MaterialTheme.typography.body1,
                        color = Color.White
                    )
                    Text(
                        text = "Reset or change your PIN",
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
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navigator.navigate(ManageSecurityQnScreenDestination)
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
                        style = MaterialTheme.typography.body1,
                        color = Color.White
                    )
                    Text(
                        text = "Update your security_screen suggestion",
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
                        style = MaterialTheme.typography.body1,
                        color = Color.White
                    )
                    Text(
                        text = "Unlock with Touch ID",
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
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navigator.navigate(ManageDeviceScreenDestination)
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
                        style = MaterialTheme.typography.body1,
                        color = Color.White
                    )
                    Text(
                        text = "Manage the devices connected to your profile",
                        maxLines = 2,
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




