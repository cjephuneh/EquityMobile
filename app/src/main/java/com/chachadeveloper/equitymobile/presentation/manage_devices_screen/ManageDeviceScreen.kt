package com.chachadeveloper.equitymobile.presentation.manage_devices_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.ui.theme.primaryGray
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@com.ramcosta.composedestinations.annotation.Destination
fun ManageDeviceScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navigator = navigator,
            title = "Manage Devices",
            showForwardArrow = true,

        )

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp, end = 30.dp)
            ){

                Text(text = "Select the devices you want to manage",
                    color = Color.White,
                    style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = stringResource(id = R.string.managedevices),
                    style =  MaterialTheme.typography.body2,
                    maxLines = 2,
                    color = Color.White
                )

                /* cards */


                /* Other cards */

                Spacer(modifier = Modifier.height(15.dp))
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
                    Column(modifier = Modifier.padding(start = 10.dp)){
                        Text(
                            text = "Mobile devices",
                            maxLines = 1,
                            style= MaterialTheme.typography.body1,
                            color = Color.White
                        )
                        Text(
                            text = "I devices",
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
                    Column(modifier = Modifier.padding(start = 10.dp)){
                        Text(
                            text = "web devices",
                            maxLines = 1,
                            style= MaterialTheme.typography.body1,
                            color = Color.White
                        )
                        Text(
                            text = "0 devices",
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






            }


        }

    }

}