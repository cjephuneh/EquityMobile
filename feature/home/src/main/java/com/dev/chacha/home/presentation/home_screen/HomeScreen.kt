package com.dev.chacha.home.presentation.home_screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryPink


@Composable
fun HomeScreen(
    onClickAction : ()-> Unit
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                modifier = Modifier.fillMaxSize(),
                title = "Home",
                showForwardArrow = true,
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues),

        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    Text(
                        text = stringResource(id = R.string.greetings),
                    )

                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = stringResource(id = R.string.home_hint),
                        maxLines = 1
                    )

                    /* Onboarding*/

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                    }

                    /* My Balance*/
                    Spacer(modifier = Modifier.height(20.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 10.dp, vertical = 10.dp)
                        ) {
                            Text(text = " My Balance")
                        }

                    }

                    /* My Account*/

                    /* Implement Card for My account */
                    Spacer(modifier = Modifier.height(20.dp))
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(text = "My account", fontSize = 20.sp)

                        Card(
                            modifier = Modifier
                                .height(150.dp)
                                .width(250.dp),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(
                                    vertical = 10.dp,
                                    horizontal = 10.dp
                                ),
                            ) {
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
                                        contentDescription = null,
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
                                Row(
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "01101010010101010")
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(text = "Saving")

                                }

                            }

                        }

                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(80.dp),
                                shape = RoundedCornerShape(8.dp),

                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(80.dp)
                                        .padding(start = 10.dp, end = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically,

                                    )
                                {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(
                                            start = 10.dp,
                                            end = 10.dp
                                        )
                                    ) {
                                        Text(
                                            text = "Add account",
                                            maxLines = 1,
                                        )
                                        Spacer(modifier = Modifier.height(1.dp))
                                        Text(
                                            text = "Add an account, card or mobile wallet",
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

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun HomeScreenPreview() {
    EquityMobileTheme {
        HomeScreen(){

        }
    }

}
