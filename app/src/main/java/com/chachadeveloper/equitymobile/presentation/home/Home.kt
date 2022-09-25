package com.chachadeveloper.equitymobile.presentation.home

import android.widget.Space
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Forward
import androidx.compose.runtime.Composable
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.domain.model.BottomNavItem
import com.chachadeveloper.equitymobile.presentation.components.StandardTextField
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.destinations.SecurityQnDestination
import com.chachadeveloper.equitymobile.presentation.onboarding.OnBoardingScreen
import com.chachadeveloper.equitymobile.presentation.register.RegisterUser
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
@Composable
@Destination
fun Home(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navigator = navigator,
            modifier = Modifier.fillMaxSize(),
            title = {
                Text(
                    text = "Home",
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

        Column {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    Text(
                            text = stringResource(id = R.string.greetings),
                            style = MaterialTheme.typography.body1
                        )

                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = stringResource(id = R.string.home_hint),
                            style =  MaterialTheme.typography.body2,
                            maxLines = 1
                        )

                        /* Onboarding*/
                    
                    Row(modifier = Modifier.fillMaxWidth().height(150.dp)) {
                        OnBoardingScreen(navigator = navigator)
                    }







                        /* My Balance*/
                        Spacer(modifier = Modifier.height(20.dp))

                            Card(modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)) {
                                Column (
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(horizontal = 10.dp, vertical = 10.dp)
                                ){
                                    Text(text = " My Balance")
                                }

                            }

                        /* My Account*/

                        /* Implement Card for My account */
                        Spacer(modifier = Modifier.height(20.dp))
                        Column(modifier = Modifier.fillMaxSize()) {
                            Text(text = "My account", fontSize = 20.sp)

                            Card(modifier = Modifier
                                .height(150.dp)
                                .width(250.dp),
                                shape= RoundedCornerShape(8.dp)
                            ) {
                                Column (modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),){
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "Stephen Chacha Marwa",
                                            maxLines = 1,
                                            fontSize = 14.sp
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.more),
                                            contentDescription =  null,
                                            modifier = Modifier
                                                .size(20.dp),
                                            colorFilter = ColorFilter.tint(color = Color.White)
                                        )

                                    }
                                    Spacer(modifier = Modifier.height(3.dp))
                                    Text(text = "8000.55KES")
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(horizontal = 10.dp, vertical = 10.dp),
                                    verticalArrangement = Arrangement.Bottom

                                    ) {
                                    Row(modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(text = "01101010010101010")
                                        Spacer(modifier = Modifier.width(5.dp))
                                        Text(text = "Saving")

                                    }


                                }


                            }

                            /* Card for add Account */
                            Spacer(modifier = Modifier.height(20.dp))

                            Column (modifier = Modifier
                                .fillMaxSize(),
                                verticalArrangement = Arrangement.Bottom
                            ){
                                Card(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp),
                                    shape= RoundedCornerShape(8.dp)
                                ){
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceEvenly,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp))
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                            contentDescription =  null,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(50.dp)
                                                .clip(CircleShape)
                                        )
                                        Column (modifier = Modifier.padding(start = 10.dp, end = 10.dp)){
                                            Text(
                                                text = "Add account" ,
                                                maxLines = 1,
                                                style= MaterialTheme.typography.body1,
                                            )
                                            Spacer(modifier = Modifier.height(1.dp))
                                            Text(text = "Add an account, card or mobile wallet",
                                                maxLines = 1,
                                                style = MaterialTheme.typography.body2,

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
                            Spacer(modifier = Modifier.height(20.dp))

                        }



                }

            }

        }
      
       
    }

}