package com.chachadeveloper.equitymobile.feature_home.presentation.home_screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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
import com.chachadeveloper.equitymobile.core.presentation.onboarding_screen.OnBoardingScreen
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryPink
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
@Destination
fun HomeScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navigator = navigator,
            modifier = Modifier.fillMaxSize(),
            title = "Home",
            showForwardArrow = true,
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
//                            Spacer(modifier = Modifier.height(16.dp))

                            Column (modifier = Modifier
                                .fillMaxSize(),
                                verticalArrangement = Arrangement.Bottom
                            ){
                                Card(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(80.dp),
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
                                Spacer(modifier = Modifier.height(10.dp))


                            }

                        }



                }

            }

        }
      
       
    }

}