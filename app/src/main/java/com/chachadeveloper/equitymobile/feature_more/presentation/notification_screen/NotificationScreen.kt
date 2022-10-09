package com.chachadeveloper.equitymobile.feature_more.presentation.notification_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
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
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryPink
import com.chachadeveloper.equitymobile.destinations.NotificationPreferencesDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun NotificationScreen(navigator: DestinationsNavigator) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        /* top bar*/
        StandardToolbar(
            navigator = navigator,
            title = "Notification",
            showForwardArrow = true,
            showBackArrow = true
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
                        .padding(start = 25.dp, end = 25.dp)
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