package com.chachadeveloper.equitymobile.presentation.transact

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowRight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.util.TestTags
import com.chachadeveloper.equitymobile.ui.theme.primaryGray
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.xml.sax.SAXParseException

@Composable
@Destination
fun Transact(navigator: DestinationsNavigator) {
    Column(modifier = Modifier
        .fillMaxSize()
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> b086056dbfb6be1f69f74076a1c2e9dfa10a1e33
>>>>>>> ece7e00aee62950feeb8bc5fdae7bce89bf2f90b
    ) {
        StandardToolbar(
            navigator = navigator,
            title = {
                Text(
                    text = "Transact",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body2
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
            LazyColumn{
                item {
                    Column {
                        Box(modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.TopStart)
                        {
                            Column(modifier = Modifier
                                .fillMaxSize()
<<<<<<< HEAD
                                .padding(horizontal = 30.dp, vertical = 30.dp)
=======
<<<<<<< HEAD
                                .padding(horizontal = 30.dp, vertical = 30.dp)
=======
                                .padding(horizontal = 20.dp, vertical = 20.dp)
>>>>>>> b086056dbfb6be1f69f74076a1c2e9dfa10a1e33
>>>>>>> ece7e00aee62950feeb8bc5fdae7bce89bf2f90b

                            ) {
                                Text(
                                    text = "What would you like to do?",
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(12.dp))

                                Card(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                    ) {
                                        Text(
                                            text = "Favourite"
                                        )
                                        Text(
                                            text = stringResource(id = R.string.favourite),
                                            maxLines = 2
                                        )
                                    }
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(20.dp)
                                    ) {
                                        Box(modifier = Modifier.fillMaxSize(),
                                            contentAlignment = Alignment.BottomEnd,
                                            ){
                                            Text(
                                                text = "Add favourite",
                                                color = primaryPink
                                            )
                                        }
                                    }

                                }
                                Spacer(modifier = Modifier.height(12.dp))

                                Text(text = "Send Money",color =  Color.White,
                                    fontSize = 18.sp)
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
                                            Column (modifier = Modifier.padding(start = 10.dp)
                                            ){
                                                Text(
                                                    text = "Own Equity account",
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

                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                                contentDescription =  null,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(50.dp)
                                                    .clip(CircleShape)
                                            )
                                            Column (modifier = Modifier.padding(start = 10.dp)
                                            ){
                                                Text(
                                                    text = "Another Equity account",
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

                                        /* Row 3*/
                                        Spacer(modifier = Modifier.height(12.dp))
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                                contentDescription =  null,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(50.dp)
                                                    .clip(CircleShape)
                                            )
                                            Column (modifier = Modifier.padding(start = 10.dp)
                                            ){
                                                Text(
                                                    text = "Pay to or top up card",
                                                    maxLines = 1,
                                                    style= MaterialTheme.typography.body1,
                                                    color = Color.White
                                                )
                                                Text(
                                                    text = "credit and prepaid cards",
                                                    maxLines = 1,
                                                    style= MaterialTheme.typography.body1,
                                                    color = Color.White,
                                                    fontSize = 12.sp

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


                                        /* Row 3*/
                                        Spacer(modifier = Modifier.height(12.dp))
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_launcher_background) ,
                                                contentDescription =  null,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(50.dp)
                                                    .clip(CircleShape)
                                            )
                                            Column(
                                                modifier = Modifier.padding(start = 10.dp)
                                            ) {
                                                Text(
                                                    text = "Mobile wallet",
                                                    maxLines = 1,
                                                    style = MaterialTheme.typography.body1,
                                                    color = Color.White
                                                )
                                                Text(
                                                    text = "send to mobile money providers",
                                                    maxLines = 1,
                                                    style = MaterialTheme.typography.body1,
                                                    color = Color.White,
                                                    fontSize = 12.sp
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
                                            start = 60.dp,
                                            end = 8.dp
                                        )
                                )


                                /*Row 5*/

                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Another Bank",
                                            maxLines = 1,
                                            style = MaterialTheme.typography.body1,
                                            color = Color.White
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
                                            start = 0.dp,
                                            end = 0.dp
                                        )
                                )

                                Spacer(modifier = Modifier.height(12.dp))


                                Text(
                                    text = "Pay With Equity",
                                    color = Color.White
                                )

                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Pay bill",
                                            maxLines = 1,
                                            style = MaterialTheme.typography.body1,
                                            color = Color.White
                                        )
                                    }
                                    Column {
                                        Box(
                                            modifier = Modifier.fillMaxWidth(),
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
                                            start = 60.dp,
                                            end = 8.dp
                                        )
                                )

                                /*Row 5*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Buy goods",
                                            maxLines = 1,
                                            style = MaterialTheme.typography.body1,
                                            color = Color.White
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
                                            start = 0.dp,
                                            end = 0.dp
                                        )
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(text = "Buy",
                                    color = Color.White
                                )

                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Buy airtime",
                                            maxLines = 1,
                                            style = MaterialTheme.typography.body1,
                                            color = Color.White
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
                                            start = 0.dp,
                                            end = 0.dp
                                        )
                                )


                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = "Withdraw cash",
                                    color = Color.White
                                )

                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Agent",
                                            maxLines = 1,
                                            style = MaterialTheme.typography.body1,
                                            color = Color.White
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
                                            start = 0.dp,
                                            end = 0.dp
                                        )
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }

                }
            }
        }
    }

}