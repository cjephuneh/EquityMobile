package com.chachadeveloper.equitymobile.presentation.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.destinations.NotificationPreferencesDestination
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun Notifications(navigator: DestinationsNavigator) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        /* top bar*/
        StandardToolbar(
            navigator = navigator,
            showBackArrow = true,
            title = {
                Text(
                    text = "Notifications",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body1
                )
            },
        )
        Spacer(modifier = Modifier.height(5.dp))


        Column {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 30.dp, end = 30.dp)
                ) {


                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp),
                        shape= RoundedCornerShape(8.dp)
                    ){
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 10.dp)
                        ) {

                            Icon(imageVector = Icons.Filled.Settings
                                , contentDescription =  null,
                                tint = primaryPink,
                                modifier = Modifier.size(60.dp)
                            )

                            Column(modifier = Modifier.padding(start = 10.dp)){
                                Text(
                                    text = "Notification Preferences",
                                    maxLines = 1,
                                    style= MaterialTheme.typography.body1,
                                    fontSize = 13.sp,
                                    modifier = Modifier.clickable {
                                        navigator.navigate(NotificationPreferencesDestination)
                                    },
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

                    }

                }
            }
        }

    }
}