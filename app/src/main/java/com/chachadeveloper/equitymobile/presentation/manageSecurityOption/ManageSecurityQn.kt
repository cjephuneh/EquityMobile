package com.chachadeveloper.equitymobile.presentation.manageSecurityOption

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.destinations.Destination
import com.chachadeveloper.equitymobile.presentation.destinations.HomeDestination
import com.chachadeveloper.equitymobile.ui.theme.primaryGray
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@com.ramcosta.composedestinations.annotation.Destination
fun ManageSecurityQn(navigator: DestinationsNavigator) {

    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navigator = navigator,
            title = {
                Text(
                    text = "Security questions",
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

        Column (verticalArrangement = Arrangement.Top){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ){
                Column (modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                ){

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
                                .padding(start = 10.dp, end = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                contentDescription =  null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Column (modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 12.dp)
                            ){
                                Text(
                                    text = "Stephen Chacha" ,
                                    maxLines = 1,
                                    style= MaterialTheme.typography.body2,
                                )
                                Spacer(modifier = Modifier.height(1.dp))
                                Text(text = "stevechacha4@gmail.com",
                                    maxLines = 1,
                                    style = MaterialTheme.typography.body2,
                                )
                                Spacer(modifier = Modifier.height(1.dp))
                                Text(text = "254746656813",
                                    maxLines = 1,
                                    style = MaterialTheme.typography.body2,
                                )
                            }


                        }

                    }

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
                                text = "Security",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "Change your sign-in details and password",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
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
                                text = "Security",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "Change your sign-in details and password",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
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
                                text = "Security",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "Change your sign-in details and password",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
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
                                text = "Security",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "Change your sign-in details and password",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
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
                                text = "Security",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "Change your sign-in details and password",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
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
                                text = "Security",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Text(
                                text = "Change your sign-in details and password",
                                maxLines = 1,
                                style= MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 10.sp
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
                                start = 8.dp,
                                end = 8.dp
                            )
                    )


                    Spacer(modifier = Modifier.height(12.dp))



                    Column (
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom
                    ){

                        Button(
                            onClick = {
                                navigator.navigate(HomeDestination)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Red,
                                backgroundColor = Color.DarkGray
                            ),

                            ) {
                            Text(
                                text = "Edit Question",
                                color = Color.Black,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                    }





                }


            }
        }

    }
}